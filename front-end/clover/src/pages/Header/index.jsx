import React, { useState } from "react";

import { useLocation, useNavigate } from "react-router-dom";
import { useCarrinho } from "../Carrinho/Context";

import cloverLogo from "../../assets/image/logo.png";
import iconPerson from "../../assets/image/person.png";
import iconCarrinho from "../../assets/image/carrinho.png";
import lupa from "../../assets/image/lupa.png";
import IconNav from "./components/IconNav";
import MinhaConta from "./components/MinhaConta";
import api from "../../Api/api";

import "./style.css";
import { useEffect } from "react";

function Header() {

  const [categoriasBanco , setCategoriasBanco] = useState();

  useEffect(() => {
  api.get().then(res => {
    // console.log(res);
    setCategoriasBanco(res.data);
  }).catch(err =>{
    console.log(err);
  });
  
  }, [])

  const rota = useLocation();

  const [produtos, setProdutos] = useState(
    [
      {
        id:1,
        nome: "Camisetas",
      },
      {
        id:2,
        nome: "Bones",
      },
      {
        id:3,
        nome: "Action Figures",
      },
      {
        id:4,
        nome: "Moletons",
      },
      {
        id:5,
        nome: "Calças",
      },

    ]);

  const [search, setSearch] = useState("");

  const searchLowerCase = search.toLocaleLowerCase();

  //   const pesquisa = //Array dos produtos vindo do back.filter//((pesquisa) =>
  //     pesquisa.nome.toLowerCase.includes(searchLowerCase)) ||
  //     pesquisa.marca.toLowerCase.includes(searchLowerCase))

  const { item = [] } = useCarrinho();

  function toggleMenu() {
    const nav = document.getElementById("nav");
    nav.classList.toggle("active");
  }

  const [abrirLista, setAbrirLista] = useState(false);
  const [subCategoria, setSubCategoria] = useState({});

  const navegar = useNavigate();

  var total = 0;

  for (let i = 0; i < item.length; i++) {
    total += item[i].quantidade;
  }

  function abaCadastroLogin() {
    return navegar("/cadastro-login");
  }

  // function abaResumoPedidos(produtos) {
  //   return navegar(`/resumo-pedidos/${produtos}`);
  // }

  function carregarLista() {
    setAbrirLista(true);
  }

  function armazenarCategoria(sub_categoria_informada) {
    setSubCategoria(sub_categoria_informada);
  }

  function minimizarLista() {
    setAbrirLista(false);
  }

  function abrirHome() {
    setAbrirLista(-1);
  }
  function irHome(){
    return navegar("/");
  }
  function abrirCarrinho() {
    return navegar("/carrinho");
  }

  function sair() {
    localStorage.clear();
    alert("SAIU");
    return navegar("/");
  }
  function navegarUsuario() {
    window.alert("TÁ NA USUÁRIO");
    return navegar("/usuario");
  }

  return (
    <>
      <div className="header-fake" />
      <header id="header" className="header">
        <div className="principal">
          <div className="pesquisa">
            <div className="input-icons">
              <input className="input-field input" type="search" />
              <img className="icon" src={lupa} />
            </div>
          </div>
          <div>
            <div id="logo" onClick={irHome} className="logo">
              <img className="logo" src={cloverLogo} />
            </div>
          </div>
          <div className="controles">
            <div className="opcao-minha-conta">
              <div className="container-minha-conta">
              <span>
                <img className="icon" src={iconPerson} />
              </span>
                <MinhaConta sair={sair} navegarUsuario={navegarUsuario} />
              </div>
            </div>
            <div className="content-carrinho" onClick={abrirCarrinho}>
              
              <span className="badge-carrinho">{total}</span>
              <span>
                <img className="icon carrinho" src={iconCarrinho} />
              </span>
              
            </div>
          </div>
        </div>

        {rota.pathname !== "/carrinho" && rota.pathname !== "/cadastro-login" && (
          <nav id="nav" className="navegation">
            <button
              aria-label="Abrir Menu"
              id="btn-mobile"
              onClick={() => toggleMenu()}
              aria-haspopup="true"
              aria-controls="menu"
              aria-expanded="false"
            >
              <span id="hamburger" />
            </button>
            <ul id="menu" role="menu" onMouseLeave={minimizarLista}>
              {/* <MinhaConta sair={sair} navegarUsuario={navegarUsuario} /> */}
              <li id="contaMobile" className="list active-header contaMobile">
                <a href="./CadastroLogin">
                  <span className="list text">Minha conta</span>
                </a>
              </li>
              <li id="carrinhoMobile" className="list carrinhoMobile" />
              {produtos?.map((colecao) => {
                return (
                  <li className="list" onMouseEnter={carregarLista}>
                    <a
                      href="/"
                      className="text"
                      key={colecao.id}
                      onMouseEnter={() =>
                        armazenarCategoria(colecao.categorias)
                      }
                    >
                      {colecao.nome}
                    </a>
                  </li>
                );
              })}
            </ul>
          </nav>
        )}
      </header>
      {abrirLista && (
        <div onMouseEnter={carregarLista} onMouseLeave={minimizarLista}>
          <IconNav categoria={categoriasBanco} />
        </div>
      )}
    </>
  );
}

export default Header;

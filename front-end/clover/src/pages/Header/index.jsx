import React, { useState } from "react";

import { useNavigate } from "react-router-dom";
import { useCarrinho } from "../Carrinho/Context";

import cloverLogo from "../../assets/image/logo.png";
import iconPerson from "../../assets/image/person.png";
import iconCarrinho from "../../assets/image/carrinho.png";
import lupa from "../../assets/image/lupa.png";
import IconNav from "./components/IconNav";
import MinhaConta from "./components/MinhaConta";

import "./style.css";

function Header() {
  // ---------- codigo para integração com o back menu de pesquisa ----------

  const [search, setSearch] = useState("");

  console.log(search);
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

  function minimizarLista() {
    setAbrirLista(false);
  }

  function abrirHome() {
    setAbrirLista(-1);
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
      <div className="header-fake"></div>
      <header id="header" className="header">
        <div className="principal">
          <div className="pesquisa">
            <div className="input-icons">
              <input className="input-field input" type="search" />
              <img className="icon" src={lupa} />
            </div>
          </div>
          <div>
            <div id="logo" onClick={abrirHome} className="logo">
              <img className="logo" src={cloverLogo} />
            </div>
          </div>
          <div className="controles">
            <div className="opcao-minha-conta">
              <span>
                <img className="icon" src={iconPerson} />
              </span>
              <div className="container-minha-conta">
                <MinhaConta sair={sair} navegarUsuario={navegarUsuario} />
              </div>
            </div>
            <div className="content-carrinho" onClick={abrirCarrinho}>
              <span>
                <img className="icon carrinho" src={iconCarrinho} />
              </span>
              <span className="badge-carrinho">{total}</span>
            </div>
          </div>
        </div>
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
            <li id="carrinhoMobile" className="list carrinhoMobile"></li>
            <li className="list" onMouseEnter={carregarLista}>
              <a href="/" className="text">
                Vestuario
              </a>
            </li>
            <li className="list" onMouseEnter={carregarLista}>
              <a href="/" className="text">
                Acessórios
              </a>
            </li>
            <li className="list" onMouseEnter={carregarLista}>
              <a href="/" className="text">
                Colecionaveis
              </a>
            </li>
            <li className="list" onMouseEnter={carregarLista}>
              <a href="/" className="text">
                Decoração
              </a>
            </li>
          </ul>
        </nav>
      </header>
      {abrirLista && (
        <div onMouseEnter={carregarLista} onMouseLeave={minimizarLista}>
          <IconNav />
        </div>
      )}
    </>
  );
}

export default Header;

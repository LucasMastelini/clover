import React, { useState } from "react";

import "./style.css";

import { NavLink, useNavigate } from "react-router-dom";

import cloverLogo from "../../assets/image/logo.png";
import iconPerson from "../../assets/image/person.png";
import iconCarrinho from "../../assets/image/carrinho.png";
import lupa from "../../assets/image/lupa.png";

import IconNav from "./components/iconNav";
import MinhaConta from "./components/minhaConta";
import IconCarrinho from "./components/iconCarrinho";
// import { useEffect } from "react";

function Header() {

  const [abrirLista, setAbrirLista] = useState(false);
  // const [itensCarrinho, setItensCarrinho] = useState();

  // const adicionarItem = useEffect(() => {
  //   setItensCarrinho(itens);
  // }, [itensCarrinho]);

  const navegar = useNavigate();

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
    alert("SAIU")
    return navegar("/");
  }
  function navegarUsuario() {
    window.alert('TÁ NA USUÁRIO');
    return navegar("/usuario");
  }

  return (
    <>
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
            <div>
              <span>
                <img className="icon" src={iconPerson} />
              </span>
              <MinhaConta sair={sair} navegarUsuario={navegarUsuario} />
            </div>
            <div className="content-carrinho" onClick={abrirCarrinho}>
              <span>
                <img className="icon carrinho" src={iconCarrinho} />
              </span>
              <span className="badge-carrinho">{3}</span>
            </div>
          </div>
        </div>
        <nav id="nav" className="navegation">
          <button
            aria-label="Abrir Menu"
            id="btn-mobile"
            className="btn-mobile"
            aria-haspopup="true"
            aria-controls="menu"
            aria-expanded="false"
          >
            Menu
            <span id="hamburger" className="hambirger"></span>
          </button>
          <ul
            id="menu"
            role="menu"
            className="menu"
            onMouseLeave={minimizarLista}
          >
            <li id="contaMobile" className="list active contaMobile">
              <span>
                <img className="icon" src={iconPerson} alt="" />
              </span>
              <a href="./CadastroLogin">
                <span className="text">Minha conta</span>
              </a>
            </li>
            <li id="carrinhoMobile" className="list carrinhoMobile"></li>
            <li className="list" onMouseEnter={carregarLista}>
              <a href="/">Vestuario</a>
            </li>
            <li className="list" onMouseEnter={carregarLista}>
              <a href="/">Acessórios</a>
            </li>
            <li className="list" onMouseEnter={carregarLista}>
              <a href="/">Colecionaveis</a>
            </li>
            <li className="list" onMouseEnter={carregarLista}>
              <a href="/">Decoração</a>
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

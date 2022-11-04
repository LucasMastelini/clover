import React, { useState } from "react";

import "./style.css";

import { NavLink, useNavigate } from "react-router-dom";

import cloverLogo from "../../assets/image/logo.png";
import iconPerson from "../../assets/image/person.png";
import carrinho from "../../assets/image/carrinho.png";
import lupa from "../../assets/image/lupa.png";

import IconNav from "./components/iconNav";
import MinhaConta from "./components/minhaConta/MinhaConta";
import { useEffect } from "react";

function Header() {
  const itens = [
    {
      id: 1,
      titulo: "Camiseta",
      valor: 79.99,
      descricao: "Uma camiseta branca lisa",
    },
    {
      id: 2,
      titulo: "Calça Jeans preta",
      valor: 65.0,
      descricao: "Deans colado",
    },
    {
      id: 3,
      titulo: "Air Nex",
      valor: -99.0,
      descricao: "Tenis mike original",
    },
  ];

  const [abrirLista, setAbrirLista] = useState(false);
  const [itensCarrinho, setItensCarrinho] = useState();

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
              <MinhaConta onClick={abaCadastroLogin}/>
            </div>  
            <div className="content-carrinho">
              <span>
                <img className="icon carrinho" src={carrinho} />
              </span>
              <span className="badge-carrinho">{itens.length}</span>
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
            <li id="carrinhoMobile" className="list carrinhoMobile">
              <NavLink href="">
                <span>
                  <img className="icon" src={carrinho} alt="" />
                </span>
                <span className="text">Carrinho</span>
              </NavLink>
            </li>
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

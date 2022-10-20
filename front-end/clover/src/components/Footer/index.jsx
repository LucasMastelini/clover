import React from "react";
import { NavLink } from "react-router-dom";

import "./style.css";

export default function Footer() {
  return (
    <>
      <footer>
        <div className="container-footer">
          <div className="item-footer">
            <h2 className="title">Institucional</h2>
            <ul className="item-lista">
              <NavLink className="nav-link" to="/quem-somos"><li>Quem somos</li></NavLink>
            </ul>
          </div>

          <div className="item-footer-two">
            <h2>Dúvidas</h2>
            <ul className="item-lista-two">
              <li>Ajuda</li>
              <li>Política de Privacidade</li>
              <li>Política de Troca e Garantia</li>
              <li>Pagamento e Envio</li>
            </ul>
          </div>

          <div className="item-footer-three">
            <h2>Contato</h2>
            <ul className="item-lista-three">
              <li>Atendimento</li>
              <li>Dúvidas</li>
              <li>Fale Conosco</li>
            </ul>
          </div>

          <div className="item-footer-four">
            <h2>Receba Novidades</h2>
            <ul className="item-lista-four">
              <li>Assine e receba novidades sempre em primeira mão</li>
              <div className="news">
                <input className="news-input" type="email" placeholder="Digite seu email"/>
                <button className="btn-news">Inscrever</button>
              </div>
            </ul>
          </div>
        </div>
      </footer>
    </>
  );
}

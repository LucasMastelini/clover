import React from "react";
import { useNavigate } from "react-router-dom";

import camiseta from "../../assets/image/Rectangle101.png";

import "./style.css";

export default function CardProduto() {
  const navigate = useNavigate();

  return (
    <>
      <div className="item" onClick={() => navigate("/compra-produto")}>
        <img className="img" src={camiseta} alt="" />

        <div className="nome-produto">Camiseta branca lisa - Masculina</div>

        <div id="containerPreco" className="container-preco">
          <div id="precoVista" className="preco-vista">
            <h1 id="precoVistaRiscado" className="preco-vista-riscado">
              R$6000
            </h1>
            <h1 id="precoVistaSemRisco" className="preco-vista-sem-risco">
              R$9000
            </h1>
          </div>

          <div className="parcelas">
            <h3 id="parcelas" className="text-parcelas">
              ou 12x de R$8,10
            </h3>
          </div>
        </div>
      </div>
    </>
  );
}

import React from "react";

import product from "../../assets/image/Rectangle101.png";

import "./style.css";

export default function CardProduto() {
  return (
    <>
      <div className="container-card">
        <div id="card" className="gradient-border">
          <img src={product} alt="" />
          <p className="texto1">Camiseta branca lisa - masculina </p>
          <p>
            <span className="valor-simulado">R$84,50</span>
            <span className="valor-produto">R$79,90</span>
          </p>
          <p className="opcao-parcela">ou 12x de R$8,10</p>
        </div>
      </div>
    </>
  );
}

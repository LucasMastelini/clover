import React from "react";
import { useNavigate } from "react-router-dom";

import camiseta from "../../assets/image/Rectangle101.png";

import "./style.css";

export default function CardProduto(props) {
  const navigate = useNavigate();
  const simulado = props.precoSimulado * 1.2;
  const precoParcelado  = props.preco / 12;

  return (
    <>
      <div className="item" onClick={() => navigate("/compra-produto")}>
        <img className="img" src={props.imagem ? camiseta: camiseta} alt="" />

        <div className="nome-produto">{props.nome}</div>

        <div id="containerPreco" className="container-preco">
          <div id="precoVista" className="preco-vista">
            <h1 id="precoVistaRiscado" className="preco-vista-riscado">
            R${simulado.toFixed(2)}
            </h1>
            <h1 id="precoVistaSemRisco" className="preco-vista-sem-risco">
            R${props.preco}
            </h1>
          </div>

          <div className="parcelas">
            <h3 id="parcelas" className="text-parcelas">
              ou 12x de R${precoParcelado.toFixed(2)}
            </h3>
          </div>
        </div>
      </div>
    </>
  );
}

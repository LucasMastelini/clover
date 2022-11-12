import React from "react";
import Header from "../Header";

import "./style.css";

function Carrinho(props) {
  const itens = [
    {
      id: 1,
      imagem: "url",
      titulo: "Camiseta",
      valor: 79.99,
      quantidade: 5,
      descricao: "Uma camiseta branca lisa",
    },
    {
      id: 2,
      imagem: "url",
      titulo: "Calça Jeans preta",
      quantidade: 1,
      valor: 65.0,
      descricao: "Deans colado",
    },
    {
      id: 3,
      imagem: "url",
      titulo: "Air Nex",
      quantidade: 2,
      valor: -99.0,
      descricao: "Tenis mike original",
    },
  ];

  return (
    <>
    <Header/>
     <div className="content-exibe-carrinho">
      <div className="contem-carrinho cabecalho">
        <div></div>
        <div> Produto</div>
        <div> Unitario</div>
        <div> Quantidade</div>
        <div> Valor</div>
        <div></div>
      </div>
     {itens.map((item) => (
        <div className="contem-carrinho" key={item.id} >
         <div>{item.imagem}</div>
         <div className="item-carrinho"> {item.titulo}</div>
         <div>R${item.valor}</div>
         <div>{item.quantidade}</div>
         <div> R${(item.valor * item.quantidade)}</div>
         <div> icon rm </div>
        </div>
      ))}
      <div className="contem-carrinho">

      </div>
     </div>
    </>
  );
}

export default Carrinho;

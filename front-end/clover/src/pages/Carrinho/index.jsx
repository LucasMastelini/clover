import React from "react";
import Header from "../Header";

import "./style.css";

function Carrinho(props) {
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

  return (
    <>
    <Header/>
      {itens.map((item) => (
        <div className="contem-carrinho" key={item.id} >
          Nome produto: {item.titulo}
          Valor R$ {item.valor}
        </div>
      ))}
      <div className="contem-carrinho">
        <h1>oi meu amooooooor</h1>
      </div>
    </>
  );
}

export default Carrinho;

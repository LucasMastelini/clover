import React from "react";

import"./style.css";

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
    {itens.map((item) => )}
    <div key={props[0].id}>
      Nome produto: {props[0].nome}
      Valor R$ {props[0].preco}
    </div>
    <div className="content-carrinho">
        <h1>
            oi meu amooooooor
        </h1>
    </div>
    </>
    
  );
};

export default Carrinho;

import React from "react";
import Header from "../Header";
import { useCarrinho } from "./Context";
import iconLixeira from "../../assets/image/DeleteFilled.png";

import "./style.css";

function Carrinho(props) {
  const {removerQuantidade , adicionarQuantidade, item = []} = useCarrinho();

  const itens = [
    {
      id: 1,
      imagem: "url",
      titulo: "Camiseta verde espelhada naruto 2023 hipoalergenica 100% algodão",
      valor: 79.99,
      descricao: "Uma camiseta branca lisa",
    },
    {
      id: 2,
      imagem: "url",
      titulo: "Calça Jeans preta",
      valor: 65.0,
      descricao: "Deans colado",
    },
    {
      id: 3,
      imagem: "url",
      titulo: "Air Nex",
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
        <div className="quantidade"> Quantidade</div>
        <div> Valor</div>
        <div></div>
      </div>
     {itens.map((itemProd) => (
        <div className="contem-carrinho" key={itemProd.id} >
         <div className="item-carrinho imagem">{itemProd.imagem}</div>
         <div className="item-carrinho"> {itemProd.titulo}</div>
         <div className="item-carrinho">R${itemProd.valor}</div>
         <div className="item-carrinho quantidade">
            <button onClick= {()=>adicionarQuantidade(itemProd.id, itemProd.titulo, itemProd.valor)}>+</button>
            {itemProd.quantidade ?? 0}
            <button onClick={()=>removerQuantidade(itemProd.id)}> - </button>
          </div>
         <div className="item-carrinho"> R${(itemProd.valor * itemProd.quantidade)}</div>
         <div className="item-carrinho rm-carrinho" onClick={()=>removerQuantidade(itemProd.id)}>
              <img className="icon" src={iconLixeira} />  
            </div>
        </div>
      ))}
      <div className="contem-carrinho">

      </div>
     </div>
    </>
  );
}

export default Carrinho;

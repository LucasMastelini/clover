import React from "react";
import Header from "../Header";
// import { useCarrinho } from "./Context";
import iconLixeira from "../../assets/image/DeleteFilled.png";

import "./style.css";
import { useState } from "react";

function Carrinho(props) {
  // const {removerQuantidade , aumentarQuantidade, item = []} = useCarrinho();

  const [itens, setItens] = useState([
    {
      id: 1,
      imagem: "url",
      titulo:
        "Camiseta verde espelhada naruto 2023 hipoalergenica 100% algodão",
      valor: 79.99,
      quantidade: 1,
      descricao: "Uma camiseta branca lisa",
    },
    {
      id: 2,
      imagem: "url",
      titulo: "Calça Jeans preta",
      valor: 65.0,
      quantidade: 1,
      descricao: "Deans colado",
    },
    {
      id: 3,
      imagem: "url",
      titulo: "Air Nex",
      valor: -99.0,
      quantidade: 1,
      descricao: "Tenis mike original",
    },
  ]);

  function aumentarQuantidade(produto) {
    let idProduto = produto.id;

    setItens(
      itens.map((item) => {
        if (item.id === idProduto) {
          item.quantidade += 1;
        }
        return item;
      })
    );
  }

  function removerQuantidade(produto) {
    let idProduto = produto.id;

    setItens(
      itens.map((item) => {
        if (item.id === idProduto && item.quantidade > 1) {
          item.quantidade -= 1;
        }
        // const listaItens = [...itens];
        // const novaLitaItens = listaItens.filter(prod => prod.id !== item.id);
        // setItens(novaLitaItens);
        
        else if(item.id === idProduto && item.quantidade ===1){
          
          
          const novaListaItens = [...itens];
          
          const itensBusca = novaListaItens.filter((itemMapeado) => itemMapeado.id !== item.id)
          setItens(itensBusca)
          // {removerProduto(item)}
          removerProduto()
          // console.log(item)
        }
        return item;
      })
    );
  }

  function removerProduto(produto) {
    let idProduto = produto.id;

    setItens(
      itens.filter((item) => item.id !== idProduto)
    )
  }

  return (
    <>
      <Header />
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
          <div className="contem-carrinho" key={itemProd.id}>
            <div className="item-carrinho imagem">{itemProd.imagem}</div>
            <div className="item-carrinho"> {itemProd.titulo}</div>
            <div className="item-carrinho">R${itemProd.valor}</div>

            <div className="item-carrinho quantidade">
              <button
                style={{ cursor: "pointer" }}
                onClick={() => aumentarQuantidade(itemProd)}
                // onClick= {()=> aumentarQuantidade(itemProd.id)}
              >
                +
              </button>
              {itemProd.quantidade}

              <button
                style={{ cursor: "pointer" }}
                onClick={() => removerQuantidade(itemProd)}
                // onClick={()=>removerQuantidade(itemProd.id)}
              >
                {" "}
                -{" "}
              </button>
            </div>

            <div className="item-carrinho">
              {" "}
              R${(itemProd.valor * itemProd.quantidade).toFixed(2)}
            </div>

            <div className="item-carrinho rm-carrinho">
              <img
                style={{ cursor: "pointer" }}
                onClick={() => removerProduto(itemProd)}
                className="icon"
                src={iconLixeira}
              />
            </div>
          </div>
        ))}

        <div className="contem-carrinho"></div>
      </div>
    </>
  );
}

export default Carrinho;

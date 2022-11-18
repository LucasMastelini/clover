import React from "react";
import Header from "../Header";
import { useCarrinho } from "./Context";
import iconLixeira from "../../assets/image/DeleteFilled.png";
import "./style.css";

function Carrinho() {
  const {
    removerQuantidade,
    aumentarQuantidade,
    removerProduto,
    item = [],
  } = useCarrinho();

  var total = 0;

  for (let i = 0; i < item.length; i++) {
    total += item[i].valor * item[i].quantidade;
  }

  return (
    <>
      <Header />
      <div className="content-exibe-carrinho">
        <div className="contem-carrinho cabecalho">
          <div />
          <div>Produto</div>
          <div>Unitario</div>
          <div className="quantidade">Quantidade</div>
          <div>Valor</div>
          <div />
        </div>
        {item.map((itemProd) => (
          <div className="contem-carrinho" key={itemProd.id}>
            <div className="item-carrinho imagem">{itemProd.imagem}</div>
            <div className="item-carrinho">{itemProd.titulo}</div>
            <div className="item-carrinho">R${" " + itemProd.valor}</div>

            <div className="item-carrinho quantidade">
              <button
                style={{ cursor: "pointer" }}
                onClick={() => aumentarQuantidade(itemProd.id)}
              >
                +
              </button>
              {itemProd.quantidade}
              <button
                style={{ cursor: "pointer" }}
                onClick={() => removerQuantidade(itemProd.id)}
              >
                {" "}
                -{" "}
              </button>
            </div>

            <div className="item-carrinho">
              {" "}
              R${" " + (itemProd.valor * itemProd.quantidade).toFixed(2)}
            </div>

            <div className="item-carrinho rm-carrinho">
              <img
                style={{ cursor: "pointer" }}
                onClick={() => removerProduto(itemProd.id)}
                className="icon"
                src={iconLixeira}
              />
            </div>
          </div>
        ))}

        <div className="contem-carrinho">
          <div className="resumo-carrinho">Subtotal: R$ {total.toFixed(2)}</div>
        </div>
      </div>
    </>
  );
}

export default Carrinho;

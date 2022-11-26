import React, { useState, useEffect } from "react";
import Header from "../Header";
import CardCupom from "./components/CardCupom";
import CampoFrete from "./components/CampoFrete"
import { useCarrinho } from "./Context";
import iconLixeira from "../../assets/image/DeleteFilled.png";
import "./style.css";

function Carrinho() {
  // const [cupom, setCupom] = useState();
  const {
    removerQuantidade,
    aumentarQuantidade,
    removerProduto,
    item = [],
    valorSubTotalItens,
  } = useCarrinho();

  const [valorTotal, setValorTotal] = useState(0);
  const [valorEnvio, setvalorEnvio] = useState(0);
  const [valorDesconto, setValorDesconto] = useState(50); //EM PORCENTAGEM %

  function calcularDesconto() {
    return (valorSubTotalItens() * valorDesconto) / 100;
  }

  useEffect(() => {
    setValorTotal(valorSubTotalItens() - calcularDesconto() + valorEnvio);
  }, [valorSubTotalItens(), valorDesconto, valorEnvio]);

  var total = 0;

  for (let i = 0; i < item.length; i++) {
    total += item[i].valor * item[i].quantidade;
  }

  // function adicionarCupom() {
  //   var valorCupom =
  // }

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

            <div className="item-carrinho"> R${" " + valorSubTotalItens()}</div>

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

        <div className="contem-resumo-carrinho">
          {/* <div>
            <div className="container-cupom">
              Cupom
              <form>
                <input type="text" />
                <button type="submit">adicionar cupom</button>
              </form>
            </div>
            <div className="content-cupom">
              <div id="cupom-compra-carrinho">
                <CardCupom></CardCupom>
              </div>
            </div>
          </div> */}
          <div className="container-calc-frete">
            <div>
            <CampoFrete></CampoFrete>
            </div>
          </div>
         
          <div className="resumo-carrinho">
          <div className="teste-resumo">
            <div className="teste-content-resumo-carrinho">
              <div></div>
              <div>
                <div className="subtotal">
                  <p>subtotal dos produtos </p>
                  <p className="exibe-valor">R$ {valorSubTotalItens()}</p>
                </div>
                <div className="envio">
                  <p>preço de envio</p>
                  <p className="exibe-valor">R$ {valorEnvio.toFixed(2)}</p>
                </div>
                {/* <div className="calc-cupom">
                  <p>desconto Cupom</p>
                  <p className="exibe-valor">R$ {calcularDesconto().toFixed(2)}</p>
                </div> */}
                <div className="total-resumo">
                  <p className="exibe-total" >Preço total</p>
                  <p className="exibe-valor exibe-total" >R$ {valorTotal.toFixed(2)}</p>
                  
                </div>
                <div className="btn-fim-compra">
                  <div />
                  <button className="content-btn-fim-compra">Finaliza compra</button>
                </div>
              </div>
            </div>
          </div>
          
          </div>
        </div>
      </div>
    </>
  );
}

export default Carrinho;

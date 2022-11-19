import "swiper/css";
import "swiper/css/navigation";
import "swiper/css/thumbs";
import "./style.css";
import ContainerSlider from "../ContainerSlider";
import { BsTruck } from "react-icons/bs";
import React, { useEffect, useState } from "react";
import Rate from "../Rate";

import img1 from "../ContainerSlider/conteudo/images/slider01.jpg";
import img2 from "../ContainerSlider/conteudo/images/slider02.jpg";
import img3 from "../ContainerSlider/conteudo/images/slider03.jpg";
import img4 from "../ContainerSlider/conteudo/images/slider04.jpg";
import img5 from "../ContainerSlider/conteudo/images/slider05.jpg";
import img6 from "../ContainerSlider/conteudo/images/slider06.jpg";
import img7 from "../ContainerSlider/conteudo/images/spider-man-pc.jpg";

import { mudarCores, mudarTamanhos } from "./transicaocor";
import { useCarrinho } from "../../../Carrinho/Context";

export default function ContainerCompra() {
  const { adicionarProduto } = useCarrinho();

  const produtoMock = {
    id: 1,
    imagem: "url",
    titulo: "Camiseta verde espelhada naruto 2023 hipoalergenica 100% algodão",
    valor: 79.99,
    valorRiscado: 120.0,
    descricao: "Uma camiseta branca lisa",
  };

  const [rating, setRating] = useState(0);

  const [show, setShow] = useState(false);
  const onClick = () => setShow(true);

  useEffect(() => {
    console.log(show);
  }, [show]);

  const [vetorImagem, setVetorImagem] = useState([]);

  const [imagens, setImagens] = useState([img1, img2, img3, img4, img5, img6]);

  // img = [
  //     {
  //         id: 1,
  //         url: "url1",
  //         cor: "branco"
  //     },
  //     {
  //         id: 2,
  //         url: "url2",
  //         cor: "amarelo"
  //     },
  //     {
  //         id: 3,
  //         url: "url3",
  //         cor: "preto"
  //     }
  // ]

  function escolherCor(corEscolhida) {
    if (corEscolhida === 1) {
      setImagens([img1, img2, img3, img4, img5, img6]);
    } else if (corEscolhida === 2) {
      setImagens([img7, img7, img7, img7, img7, img7]);
    } else {
      setImagens([img5, img6]);
    }
  }

  return (
    <>
      <section className="produto">
        <div className="slides">
          <ContainerSlider images={imagens} />
        </div>
        <div className="informacoes">
          <h1 className="titulo">
            Camiseta Gonew Dry Touch Fast Masculina - Branco
          </h1>
          <div className="avaliacao-vendidos">
            <div className="avaliacao">
              <h3 className="avaliacao-titulo">Avaliação</h3>
            </div>
            <Rate rating={rating} onRating={(rate) => setRating(rate)} />
            <h3 className="vendidos">Vendidos: +999999</h3>
          </div>
          <div className="calculo-frete">
            <BsTruck />
            <h4 className="titulo-calcular-frete">calcular o frete</h4>
            <div className="calcular">
              <input className="input-calcular" placeholder="Insira o CEP" />
              <button
                className="button-calcular"
                type="button"
                onClick={onClick}
              >
                Calcular
              </button>
            </div>
          </div>
          {show ? <Text /> : null}
          <div className="cores">
            <h3>Selecione a cor</h3>
            <div id="opcoesCores" onClick={mudarCores}>
              <div
                id="cor1"
                className="cor1"
                onClick={() => escolherCor(1)}
              ></div>
              <div
                id="cor2"
                className="cor2"
                onClick={() => escolherCor(2)}
              ></div>
              <div
                id="cor3"
                className="cor3"
                onClick={() => escolherCor(3)}
              ></div>
            </div>
          </div>
          <div className="tamanhos" onClick={mudarTamanhos}>
            <h3>Selecione o tamanho</h3>
            <div id="opcoesTamanhos">
              <div id="tamanhoP">P</div>
              <div id="tamanhoM">M</div>
              <div id="tamanhoG">G</div>
            </div>
          </div>
          <div className="preco">
            <div className="preco-vista">
              <h1 className="preco-vista-riscado">
                R${" " + produtoMock.valorRiscado}
              </h1>
              <h1 className="preco-vista-sem-risco">
                R${" " + produtoMock.valor}
              </h1>
            </div>
            <h3 className="parcelas">
              ou 12x de R${" " + (produtoMock.valor / 12).toFixed(2)}
            </h3>
          </div>
          <button
            className="comprar"
            onClick={() =>
              adicionarProduto(
                produtoMock.id,
                produtoMock.titulo,
                produtoMock.valor,
              )
            }
          >
            Comprar
          </button>
        </div>
      </section>
    </>
  );
}

const Text = () => <div>You clicked the button!</div>;

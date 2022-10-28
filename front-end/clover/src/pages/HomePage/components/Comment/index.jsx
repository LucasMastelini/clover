import React from "react";

import iconComment from "../../../../assets/image/iconComentario.png";
import nota from "../../../../assets/image/nota.png";

import "./style.css";

export default function Comment(props) {
  const arrayDepoimentos = [
    {
      data: "17/10/2022",
      texto: "Comprei por decisão do meu filho em presentear um amigo. O produto foi entregue conforme o anúncio. Saliento quanto a forma de pagamento é facilitada e a entrega rápida!!",
      nome: "Nívea R",
    },
    {
      data: "26/10/2022",
      texto: "Gostei do site, do Instagram e do serviço de entrega e rastreamento da entrega.",
      nome: "Beatriz M",
    },
    {
      data: "10/10/2022",
      texto: "Gostei bastante da entrega, foi rápida e correta. Só não gostei da embalagem, um saco plástico, fino. que pode ser facilmente rasgado.",
      nome: "Elana E",
    },
    {
      data: "10/10/2022",
      texto: "Adoro os produtos! Sempre com ideias de estampas criativas dos meus heróis e personagens favoritos!!!",
      nome: "Fernando S",
    },
    {
      data: "26/10/2022",
      texto: "Adorei que chegou tudo muito rápido, o site eh fácil de navegar, encontrei o que precisava de forma prática",
      nome: "Mirian G",
    },
    {
      data: "25/10/2022",
      texto: "Camisetas boa e bom atendimento,vários produtos para presentear. Só deixa a desejar que os tamanhos acabam rápido",
      nome: "Jonathan O",
    },
  ];

  return (
    <>
      {arrayDepoimentos.map((depoimento) => (
        <button className="item-comments">
          <span className="top-comments">
            <img src={iconComment} alt="" />
            <p>{depoimento.data}</p>
          </span>
          <span className="middle-comments">
            <p className="text-comments">{depoimento.texto}</p>
            <h4>{depoimento.nome}</h4>
          </span>
          <img src={nota} alt="" />
        </button>
      ))}
    </>
  );
}

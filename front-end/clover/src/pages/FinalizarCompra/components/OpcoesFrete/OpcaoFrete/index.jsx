import React from "react";

export default function OpcaoFrete(props) {
  return (
    <>
      <div className="opcao-frete">
        <input type="radio" name="question-one" value="12,55" />
        <p className="descricao-frete">
          <span>{props.tipo_frete}</span>
          {props.tempo_previsto}
        </p>
        <div className="line-frete"></div>
        <h5>R$ {props.preco}</h5>
      </div>
    </>
  );
}

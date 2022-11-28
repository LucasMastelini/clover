import React from "react";
import { IMaskInput } from "react-imask";
import { BsTruck } from "react-icons/bs";
import "./style.css";

function CampoFrete() {
  return (
    <>
      {" "}
      <div className="calculo-frete">
        <BsTruck />
        <h4 className="titulo-calcular-frete">calcular o frete</h4>
        <div className="calcular">
          <IMaskInput className="input-calcular" mask="0 0000-000" placeholder="Insira o CEP" />

          <button
            className="button-calcular"
            type="button"
            // onClick={onClick}
          >
            Calcular
          </button>
        </div>
      </div>
    </>
  );
}

export default CampoFrete;

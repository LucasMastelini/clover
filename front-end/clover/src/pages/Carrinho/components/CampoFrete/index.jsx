import React from "react";
import { IMaskInput } from "react-imask";
import { BsTruck } from "react-icons/bs";
import "./style.css";
import OpcoesFrete from "../../../FinalizarCompra/components/OpcoesFrete";

function CampoFrete() {

  function verOpcoesFrete() {
    return (<OpcoesFrete/>);
  }

  return (
    <>
      {" "}
      <div className="calculo-frete">
        <BsTruck />
        <h4 className="titulo-calcular-frete">calcular o frete</h4>
        <div className="calcular">
          <IMaskInput className="input-calcular" mask="00000-000" placeholder="Insira o CEP" />

          <button
            className="button-calcular"
            type="button"
            onClick={verOpcoesFrete()}
          >
            Calcular
          </button>
        </div>
      </div>
    </>
  );
}

export default CampoFrete;

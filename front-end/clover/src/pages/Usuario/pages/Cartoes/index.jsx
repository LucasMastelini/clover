import React from "react";
import OpcoesCadastradas from "../../../FinalizarCompra/components/OpcoesCadastradas";
import "./style.css";

function Cartoes() {
  return (
    <>
      <div className="container-cartoes">
        <OpcoesCadastradas
          logradouro={"JULIA SILVA SANTOS"}
          cep={"1234 **** **** 3456"}
          cidade={"Vencimento: 12/23"}
        />
      </div>
    </>
  );
}

export default Cartoes;

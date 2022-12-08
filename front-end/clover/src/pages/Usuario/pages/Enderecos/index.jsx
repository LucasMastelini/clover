import React from "react";
import OpcoesCadastradas from "../../../FinalizarCompra/components/OpcoesCadastradas";

import "./style.css";

function Enderecos() {
  return (
    <>
      <div className="container-enderecos">
        <OpcoesCadastradas
          logradouro={"Avenida Rosa Fioravante"}
          number={189}
          cep={"CEP: 09862-305"}
          cidade={"São Bernardo do Campo"}
          uf={"SP"}
        />
      </div>
    </>
  );
}

export default Enderecos;

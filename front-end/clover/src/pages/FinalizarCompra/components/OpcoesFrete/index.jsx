import React from "react";
import OpcaoFrete from "./OpcaoFrete";

import "./style.css";

export default function OpcoesFrete() {
  return (
    <>
      <div className="opcoes-entrega">
        <div className="opcao-entrega">
          <OpcaoFrete 
            tipo_frete={"Express"}
            tempo_previsto={"Em até 1 dia útil"}
            preco={"35,55"}/>
          <OpcaoFrete 
            tipo_frete={"Rápido"}
            tempo_previsto={"Em até 2 dias úteis"}
            preco={"27,55"}/>
        </div>
        <div className="opcao-entrega">
        <OpcaoFrete 
            tipo_frete={"Normal"}
            tempo_previsto={"Em até 5 dias úteis"}
            preco={"12,55"}/>
        </div>
      </div>
    </>
  );
}

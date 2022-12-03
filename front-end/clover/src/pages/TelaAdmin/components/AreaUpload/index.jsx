import React from "react";
import ArquivoRegistrado from "../ArquivoRegistrado";

import "./style.css";

export default function AreaUpload() {
  return (
    <>
      <div className="container-upload">
        <form class="form-upload">
          <label class="input-personalizado">
            <span class="botao-selecionar">Selecione um arquivo que deseja armazenar...</span>
            <input type="file" class="input-file" accept="image/*" />
          </label>
        </form>
        <div className="body-arquivos-registrados">
          <ArquivoRegistrado />
        </div>
      </div>
    </>
  );
}

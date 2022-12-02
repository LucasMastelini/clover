import React from "react";
import ArquivoRegistrado from "../ArquivoRegistrado";

import "./style.css";

export default function AreaUpload() {
  return (
    <>
      <div className="container-upload">
        <form action="">
          <div className="body-upload">
            <input
              accept=""
              multiple
              type="file"
              name=""
              id=""
              placeholder="Arraste arquivos aqui..."
            />
            <label htmlFor="arquivo">Arraste seu arquivo aqui...</label>
          </div>
        </form>
        <div className="body-arquivos-registrados">
          <ArquivoRegistrado />
        </div>
      </div>
    </>
  );
}

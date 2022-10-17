import React from "react";

import './style.css';

export default function CarroselCards({children}) {
  return (
    <>
      <div className="collabs-container">
        <div className="items-collabs">
          {children}
        </div>

        <div className="arrow-slides-middle bloquear-selecao">
          <div className="arrow-right" onclick="plusDivs(-1)">&#10094;</div>
          <div className="arrow-left" onclick="plusDivs(1)">&#10095;</div>
        </div>
      </div>
    </>
  );
}

import React from "react";
import './style.css'

function Slider() {
  return (
    <>
      <div class="display-container">
        <div class="slider">
          <img
            class="img-slides"
            src="https://lojapiticas.vteximg.com.br/arquivos/ids/167929/SDA%20DESK.png?v=637993828253800000"
            alt=""
          />
          {/* <img class="img-slides"src="https://lojapiticas.vteximg.com.br/arquivos/ids/167781/Full_1920x545_v1.png?v=637970367695270000" alt=""/>
            <img class="img-slides" src="https://lojapiticas.vteximg.com.br/arquivos/ids/167712/one-piece-adsFull.png?v=637950470315230000" alt=""/> */}

          <div class="arrow-slides bloquear-selecao">
            <div class="arrow-right" onclick="plusDivs(-1)">
              &#10094;
            </div>
            <div class="arrow-left" onclick="plusDivs(1)">
              &#10095;
            </div>
          </div>
        </div>

        <div class="page-control">
          <span class="item-page-control" onclick="currentDiv(1)"></span>
          <span class="item-page-control" onclick="currentDiv(2)"></span>
          <span class="item-page-control" onclick="currentDiv(3)"></span>
        </div>
      </div>
    </>
  );
}

export default Slider;

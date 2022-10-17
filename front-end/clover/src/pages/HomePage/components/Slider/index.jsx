import React from "react";
import './style.css'

function Slider() {

  const plusDivs = () => {
    
  } 

  return (
    <>
      <div className="display-container">
        <div className="slider">
          <img
            className="img-slides"
            src="https://lojapiticas.vteximg.com.br/arquivos/ids/167929/SDA%20DESK.png?v=637993828253800000"
            alt=""
          />
          {/* <img className="img-slides"src="https://lojapiticas.vteximg.com.br/arquivos/ids/167781/Full_1920x545_v1.png?v=637970367695270000" alt=""/>
            <img className="img-slides" src="https://lojapiticas.vteximg.com.br/arquivos/ids/167712/one-piece-adsFull.png?v=637950470315230000" alt=""/> */}

          <div className="arrow-slides bloquear-selecao">
            <div className="arrow-right" onClick={plusDivs(-1)}>
              &#10094;
            </div>
            <div className="arrow-left" onClick="plusDivs(1)">
              &#10095;
            </div>
          </div>
        </div>

        <div className="page-control">
          <span className="item-page-control" onClick="currentDiv(1)"></span>
          <span className="item-page-control" onClick="currentDiv(2)"></span>
          <span className="item-page-control" onClick="currentDiv(3)"></span>
        </div>
      </div>
    </>
  );
}

export default Slider;

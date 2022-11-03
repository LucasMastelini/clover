import React, { useEffect } from "react";
import "./style.css";

function Slider() {
  useEffect(() => {

    // {
    //   if (e.target.value.length <= 4) {
    //     setMensagemErro(true)
    //   }
    //     {/* {
    //   5 > 2 ? <div style={{color: "#fffff"}}>SIM cinco e maior que dois</div> : <div>nunca vou cair aqui</div>
    // } */}
    // }
    var slideIndex = 1;
    function carousel(n) {
      var i;
      var x = document.getElementsByClassName("img-slides");
      var y = document.getElementsByClassName("item-page-control");
      console.log("Esse e o indece x: ",x);
      console.log("Esse e o indece y", y);  
      for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
        if (i === 0 ) {
          y[i].style.backgroundColor = "green";
        } 
        else if (i === 1) {
          y[i].style.backgroundColor = "red";
        } else if (i === 2) {
          y[i].style.backgroundColor = "blue";
        } else {
           y[i].style.backgroundColor = "gray";
        }
        //bryan.braga
      }
      slideIndex++;
      if (slideIndex > x.length) {
        slideIndex = 1;
      }
      x[slideIndex - 1].style.display = "block";
      setTimeout(carousel, 6000); // Change image every 2 seconds
    }

    carousel();

  }, []);

  return (
    <>
      <div className="display-container">
        <div className="slider">
          <img
            className="img-slides"
            src="https://lojapiticas.vteximg.com.br/arquivos/ids/167929/SDA%20DESK.png?v=637993828253800000"
            alt=""
          />
          <img
            className="img-slides"
            src="https://lojapiticas.vteximg.com.br/arquivos/ids/167781/Full_1920x545_v1.png?v=637970367695270000"
            alt=""
          />
          <img
            className="img-slides"
            src="https://lojapiticas.vteximg.com.br/arquivos/ids/167712/one-piece-adsFull.png?v=637950470315230000"
            alt=""
          />

          {/* <div className="arrow-slides bloquear-selecao">
            <div className="arrow-right">&#10094;</div>
            <div className="arrow-left">&#10095;</div>
          </div> */}
        </div>

        <div className="page-control">
          <span className="item-page-control"></span>
          <span className="item-page-control"></span>
          <span className="item-page-control"></span>
        </div>
      </div>
    </>
  );
}

export default Slider;

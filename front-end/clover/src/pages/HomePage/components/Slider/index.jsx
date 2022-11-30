import React, { useEffect } from "react";
import "./style.css";

function Slider() {
  useEffect(() => {
    var slideIndex = 1;
    function carousel(n) {
      var i;
      var x = document.getElementsByClassName("img-slides");
 
      for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
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
        </div>
      </div>
    </>
  );
}

export default Slider;

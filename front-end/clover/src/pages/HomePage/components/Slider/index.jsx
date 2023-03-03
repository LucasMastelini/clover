import React, { useEffect } from "react";
import "./style.css";
import slide1 from "../../../../assets/image/the_last_of_us.jpg"
import slide2 from "../../../../assets/image/lancamento_dc.jpg"
import slide3 from "../../../../assets/image/wandinha.jpg"

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
            src={slide1}
            alt=""
          />
          <img
            className="img-slides"
            src={slide2}
            alt=""
          />
          <img
            className="img-slides"
            src={slide3}
            alt=""
          />
        </div>
      </div>
    </>
  );
}

export default Slider;

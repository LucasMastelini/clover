import React, {useRef} from "react";

import './style.css';

export default function CarroselCards({children}) {

  const carousel = useRef(null);

  const handLeftClick = (e) => {
    e.preventDefault();
    carousel.current.scrollLeft -= carousel.current.offsetWidth;
  }

  const handRightClick = (e) => {
    e.preventDefault();
    carousel.current.scrollLeft += carousel.current.offsetWidth;
  }


  return (
    <>
      <div className="collabs-container">
        <div className="items-collabs" ref={carousel}>
          {children}
        </div>

        <div className="arrow-slides-middle bloquear-selecao">
          <div className="arrow-left" onClick={handLeftClick}>&#10094;</div>
          <div className="arrow-right" onClick={handRightClick}>&#10095;</div>
        </div>
      </div>
    </>
  );
}

import React, {useRef} from "react";

import './style.css';

export default function NumeradorPaginas(props) {
  const paginador = props.count;

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
      <div className="paginacao-container">
        <div className="items-paginacao" ref={carousel}>
            <div className="itens-numeracao-paginas">
             
            </div>
        </div>

        <div className="arrow-middle bloquear-selecao">
          <div className="left" onClick={handLeftClick}>&#10094;</div>
          <div className="right" onClick={handRightClick}>&#10095;</div>
        </div>
      </div>
    </>
  );
}

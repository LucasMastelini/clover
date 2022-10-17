import React from "react";

import imgMoletom from '../../../../assets/image/imgMoletom.png';
import imgCamiseta from '../../../../assets/image/imgCamiseta.png';
import imgDecoracao from '../../../../assets/image/imgDecoracao.png';
import imgAcessorios from '../../../../assets/image/imgAcessorios.png';

import './style.css';

export default function Colection() {
  return (
    <>
      <div className="colletions-container">
        <div className="group-one-collections">
          <div className="item-collection-one">
            <img className="img-collection" src={imgMoletom} alt="" />
            <h2 className="text-collection-img">MOLETONS</h2>
          </div>
          <div className="item-collection-one">
            <img className="img-collection" src={imgCamiseta} alt="" />
            <h2 className="text-collection-img">CAMISETAS</h2>
          </div>
        </div>

        <div className="group-two-collections">
          <div className="item-collection-two">
            <img className="img-collection" src={imgDecoracao} alt="" />
            <h2 className="text-collection-img">DECORAÇÃO</h2>
          </div>
          <div className="item-collection-two">
            <img className="img-collection" src={imgAcessorios} alt="" />
            <h2 className="text-collection-img">ACESSÓRIOS</h2>
          </div>
        </div>
      </div>
    </>
  );
}

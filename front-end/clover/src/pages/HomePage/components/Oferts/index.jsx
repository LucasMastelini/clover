import React from "react";

import iconTruck from '../../../../assets/image/iconTruck.png';
import iconCard from '../../../../assets/image/iconCreditCard.png';
import iconReload from '../../../../assets/image/iconReload.png';

import './style.css'

function Oferts() {
  return (
    <>
      <div className="ofert-container">

        <div className="grid-ofert">
          <div className="item-grid border">
            <img className="img-grid" src={iconTruck} alt="" />
            <p className="text-grid">Frete grátis nas compras acima de R$250</p>
          </div>

          <div className="item-grid border">
            <img className="img-grid" src={iconCard} alt="" />
            <p className="text-grid">
              Parcele em até 10x sem juros em compras acima de R$ 499
            </p>
          </div>

          <div className="item-grid">
            <img className="img-grid" src={iconReload} alt="" />
            <p className="text-grid">
              Troque ou devolva suas compras com facilidade no site
            </p>
          </div>
        </div>
        
      </div>
    </>
  );
}

export default Oferts;

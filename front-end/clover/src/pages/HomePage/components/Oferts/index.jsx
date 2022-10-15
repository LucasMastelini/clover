import React from "react";
import './style.css'

function Oferts() {
  return (
    <>
      <div className="ofert-container">
        <div className="line-style"></div>

        <div className="grid-ofert">
          <div className="item-grid border">
            <img className="img-grid" src="/images/icon_truck.png" alt="" />
            <p class="text-grid">Frete grátis nas compras acima de R$250</p>
          </div>

          <div className="item-grid border">
            <img className="img-grid" src="/images/icon_credit-card.png" alt="" />
            <p className="text-grid">
              Parcele em até 10x sem juros em compras acima de R$ 499
            </p>
          </div>

          <div className="item-grid">
            <img className="img-grid" src="/images/icon_reload.png" alt="" />
            <p className="text-grid">
              Troque ou devolva suas compras com facilidade no site
            </p>
          </div>
        </div>

        <div className="line-style"></div>
      </div>
    </>
  );
}

export default Oferts;

import React from "react";

import instaOne from '../../assets/image/imgInstaOne.png';
import instaTwo from '../../assets/image/imgInstaTwo.png';
import instaThree from '../../assets/image/imgInstaThree.png';
import instaFour from '../../assets/image/imgInstaFour.png';
import instaFive from '../../assets/image/imgInstaFive.png';

import './style.css';

export default function RedesSociais() {
  return (
    <>
      <section class="nossas-redes">
        <div class="container-redes">
          <div class="redes-icons scard-verde-icon">
            <ion-icon name="logo-instagram"></ion-icon>
            <div class="texto-redes">
              <p class="texto-rosap">Siga nosso</p>
              <p class="texto-rosag">Instagram</p>
            </div>
          </div>
          <div class="scard-verde-icon">
            <ion-icon name="logo-facebook"></ion-icon>
            <div class="texto-redes">
              <p class="texto-rosap">Curta nosso</p>
              <p class="texto-rosag">Facebook</p>
            </div>
          </div>
        </div>
      </section>
      <section class="redes-img">
        <div class="grid-container-redes">
          <img class="grid-item" src={instaOne} alt="" />
          <img class="grid-item" src={instaTwo} alt="" />
          <img class="grid-item" src={instaThree} alt=""/>
          <img class="grid-item" src={instaFour} alt="" />
          <img class="grid-item" src={instaFive} alt="" />
        </div>
      </section>
    </>
  );
}

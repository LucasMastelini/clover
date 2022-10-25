import React from "react";

import instaOne from '../../assets/image/imgInstaOne.png';
import instaTwo from '../../assets/image/imgInstaTwo.png';
import instaThree from '../../assets/image/imgInstaThree.png';
import instaFour from '../../assets/image/imgInstaFour.png';
import instaFive from '../../assets/image/imgInstaFive.png';
import { AiFillInstagram } from "react-icons/ai";
import { FaFacebookSquare } from "react-icons/fa";

import './style.css';

export default function RedesSociais() {
  return (
    <>
      <section className="nossas-redes">
        <div className="container-redes">
          <div className="redes-icons">
            <AiFillInstagram/>
            <div className="texto-redes">
              <p className="texto-rosap">Siga nosso</p>
              <p className="texto-rosag">Instagram</p>
            </div>
          </div>
          <div className="redes-icons">
            <FaFacebookSquare/>
            <div className="texto-redes">
              <p className="texto-rosap">Curta nosso</p>
              <p className="texto-rosag">Facebook</p>
            </div>
          </div>
        </div>
      </section>
      <section className="redes-img">
        <div className="grid-container-redes">
          <img className="grid-item" src={instaOne} alt="" />
          <img className="grid-item" src={instaTwo} alt="" />
          <img className="grid-item" src={instaThree} alt=""/>
          <img className="grid-item" src={instaFour} alt="" />
          <img className="grid-item" src={instaFive} alt="" />
        </div>
      </section>
    </>
  );
}

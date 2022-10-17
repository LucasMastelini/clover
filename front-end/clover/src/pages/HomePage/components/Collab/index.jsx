import React from "react";

import imgDisney from '../../../../assets/image/imgDisney.png';
import imgMarvel from '../../../../assets/image/imgMarvel.png';
import imgStranger from '../../../../assets/image/imgStranger.png';
import imgDC from '../../../../assets/image/imgDC.png';
import imgStarWars from '../../../../assets/image/imgStarWars.png';

import './style.css'

export default function Collab() {
  return (
    <>
      <button className="item-collabs">
        <img src={imgDisney} alt="" />
      </button>
      <button className="item-collabs">
        <img src={imgMarvel} alt="" />
      </button>
      <button className="item-collabs">
        <img src={imgStranger} alt="" />
      </button>
      <button className="item-collabs">
        <img src={imgDC} alt="" />
      </button>
      <button className="item-collabs">
        <img src={imgStarWars} alt="" />
      </button>
      <button className="item-collabs">
        <img src={imgDisney} alt="" />
      </button>
    </>
  );
}

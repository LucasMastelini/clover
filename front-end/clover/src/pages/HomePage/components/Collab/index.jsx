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
        {
          [imgDisney, imgMarvel, imgStranger, imgDC, imgStarWars].map((item)=>(
            <button className="item-collabs" key={item}>
              <img src={item} alt="" />
            </button>
          ))
        }
    </>
  );
}

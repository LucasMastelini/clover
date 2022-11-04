import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import carrinho from "../../../../assets/image/carrinho.png";

import "./style.css";

function IconCarrinho(props) {



 const navigate = useNavigate();

  function abrirCarrinho(){
    return(navigate("/carrinho"));
  }
  return (
    <></>
  );
}

export default IconCarrinho;

import React from "react";

import { useNavigate } from "react-router-dom";

import "./minhaConta.css";

function MinhaConta() {
  const navegar = useNavigate();

  function navegarCadastroLogin() {
    return navegar("/cadastro-login");
  }

  return (
    <span onClick={navegarCadastroLogin} className="text">
      Minha conta
    </span>
  );
}

export default MinhaConta;

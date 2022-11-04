import React from "react";
import iconPerson from "../../../../assets/image/person.png";
import "./minhaConta.css";

import { useNavigate } from "react-router-dom";
import Usuario from "../../../Usuario";


function MinhaConta() {
  const navegar = useNavigate();

  function navegarCadastroLogin() {
    return navegar("/cadastro-login");
  }
  function sair(){
    return sair("/")
  }
  function navegarUsuario(){
    return Usuario("/usuario");
  }

  return (
  <>
    {/* <span onClick={navegarCadastroLogin} className="text">
      Minha conta
    </span> */}

    <span>
      Olá, nome
    </span>
     <select className="menu-perfil">
      <option value="" className="option-color"></option>
      <option value="" className="option-color" onClick={sair}>Sair</option>
      <option value="" className="option-color" onClick={navegarUsuario}>
        <img className="icon" src={iconPerson} />
          Meu Perfil
      </option>
    </select>
   </>
   
  );
}

export default MinhaConta;

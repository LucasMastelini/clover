import React from "react";
import iconPerson from "../../../../assets/image/person.png";
import { useNavigate } from "react-router-dom";
import "./style.css";
import { useEffect } from "react";
import { useState } from "react";

function MinhaConta({ sair, navegarUsuario }) {
  const navegar = useNavigate();

  function navegarCadastroLogin() {
    return navegar("/cadastro-login");
  }

  const [acessoUsuario, setAcessoUsuario] = useState({
    nome: localStorage.getItem("nome"),
    email: localStorage.getItem("email")
  });  


  return (
    <>
      {!acessoUsuario.nome ? (
        <span onClick={navegarCadastroLogin} className="text">
          Minha conta
        </span>
      ) : (
        <>
          {/* {" "} */}
          <span>Olá, {acessoUsuario.nome.split(" ")[0]}</span>
          <select className="menu-perfil">
            <option value="" className="option-color"></option>
            <option value="" className="option-color" onClick={sair}>
              Sair
            </option>
            <option value="" className="option-color" onClick={navegarUsuario}>
              <img className="icon" src={iconPerson} />
              Meu Perfil
            </option>
          </select>
        </>
      )}
    </>
  );
}

export default MinhaConta;

import React from "react";
import iconPerson from "../../../../assets/image/person.png";
import { useNavigate } from "react-router-dom";
import "./style.css";

function MinhaConta({ sair, navegarUsuario }) {
  const navegar = useNavigate();

  function navegarCadastroLogin() {
    return navegar("/cadastro-login");
  }
  //  localStorage.setItem('nome-usuario','Brenda')
  const acessoUsario = JSON.parse(localStorage.getItem("responseKey")) ;
  console.log(acessoUsario);
  // var nome = acessoUsario.nome.split(" ");

  return (
    <>
      {acessoUsario === null ? (
        <span onClick={navegarCadastroLogin} className="text">
          Minha conta
        </span>
      ) : (
        <>
          {" "}
          <span>Olá, {/*nome[0]*/}</span>
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

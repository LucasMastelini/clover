import Header from "../Header"
import PedidosRealizados from "./pages/PedidosRealizados";
import Cartoes from "./pages/Cartoes";
import DadosPessoais from "./pages/DadosPessoais";
import Enderecos from "./pages/Enderecos";
import { FaRegUserCircle, FaTshirt, FaCity, FaAddressCard } from "react-icons/fa";
import { BsFillCreditCardFill } from "react-icons/bs";
import { useState } from "react";
import "./style.css";

var opcaoAnterior;

  function mudarOpcoes(event) {

    var opcao1 = document.getElementById("sidebar-user-option1");
    opcao1.classList.remove("selected");

    if (opcaoAnterior) {
      opcaoAnterior.className = "";
    }

    opcaoAnterior = document.getElementById(event.target.id);
    opcaoAnterior.className = "selected";
  }

  function Usuario() {

    const [step, setStep] = useState(1);

  return (
    <>
      <Header />
      <div className="container-geral">
        <div id="container-principal" onClick={mudarOpcoes}>
          <div className="welcome">
            <FaRegUserCircle className="user" />{" "}
            <p className="welcome-user-text">Olá, Barreira!</p>
          </div>
          <div id="sidebar-user-option1" class="selected" onClick={() => setStep(1)}>
            <FaTshirt className="icon" /> Pedidos
          </div>
          <div id="sidebar-user-option2" onClick={() => setStep(2)}>
            <BsFillCreditCardFill className="icon" /> Cartões
          </div>
          <div id="sidebar-user-option3" onClick={() => setStep(3)}>
            <FaAddressCard className="icon" /> Dados Pessoais
          </div>
          <div id="sidebar-user-option4" onClick={() => setStep(4)}>
            <FaCity className="icon" /> Endereços
          </div>
          <div id="sidebar-user-option5" onClick={() => setStep(5)}>
            <FaTshirt className="icon" /> Sair
          </div>
        </div>
        <div className="container-corpo">
          {step === 1 ? <PedidosRealizados /> : ""}
          {step === 2 ? <Cartoes /> : ""}
          {step === 3 ? <DadosPessoais /> : ""}
          {step === 4 ? <Enderecos /> : ""}
        </div>
      </div>
    </>
  );
}

export default Usuario;

import Header from "../Header"
import PedidosRealizados from "./pages/PedidosRealizados";
import Cartoes from "./pages/Cartoes";
import DadosPessoais from "./pages/DadosPessoais";
import Enderecos from "./pages/Enderecos";

import {
  FaRegUserCircle,
  FaTshirt,
  FaCity,
  FaAddressCard,
} from "react-icons/fa";
import { BsFillCreditCardFill } from "react-icons/bs";
import { useState } from "react";

import "./style.css";

function Usuario() {

    const [step, setStep] = useState(0);

  return (
    <>
      <Header/>
      <div className="container-geral">
        <div className="container-principal">
          <div className="welcome">
            <FaRegUserCircle className="user" />{" "}
            <p className="welcome-user-text">Olá, Barreira!</p>
          </div>
          <div className="option" onClick={() => setStep(1)}>
            <FaTshirt className="icon" />
            <p className="icon-title">Pedidos</p>
          </div>
          <div className="option" onClick={() => setStep(2)}>
            <BsFillCreditCardFill className="icon" />
            <p className="icon-title">Cartões</p>
          </div>
          <div className="option" onClick={() => setStep(3)}>
            <FaAddressCard className="icon" />
            <p className="icon-title">Dados Pessoais</p>
          </div>
          <div className="option" onClick={() => setStep(4)}>
            <FaCity className="icon" />
            <p className="icon-title">Endereços</p>
          </div>
          <div className="option" onClick={() => setStep(5)}>
            <FaTshirt className="icon" />
            <p className="icon-title">Sair</p>
          </div>
        </div>
        <div className="container-corpo">
          {step === 1 ? <PedidosRealizados/> : ""}
          {step === 2 ? <Cartoes/> : ""}
          {step === 3 ? <DadosPessoais/> : ""}
          {step === 4 ? <Enderecos/> : ""}
        </div>
      </div>
    </>
  );
}

export default Usuario;

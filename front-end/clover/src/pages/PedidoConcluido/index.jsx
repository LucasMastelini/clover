import React, { useState } from "react";
import StepNavigation from "../stepNavigation";
import LogoPedido from "./assets/logo-caixa-produto.png"

function PedidoConcluido() {

  const labelArray = ['Recebido', 'Aprovado', 'Enviado', 'Em Trânsito', 'Entregue']
  const [currentStep, updateCurrentStep] = useState(1);

  function updateStep(step) {
    updateCurrentStep(step);
  }

  return (
      
    <div className="App">
     <img className="logo" src={LogoPedido} alt="Logo"></img>
    <h1 className="titulo-produto">Pedido Recebido</h1>
    <div className="descricao-geral">
    <p className="texto-descricao-subtitulo">Olá, <strong>*NOME*!</strong> Tudo bem?</p>
    <p className="texto-descricao-produto">Seu pedido  <strong>UCISADDASDAS</strong> foi recebido com sucesso.</p>
    <p className="texto-descricao-produto-2">Obrigado por escolher a Clover. É muito bom ter você aqui!</p> 

    </div>

      <StepNavigation labelArray={labelArray} currentStep={currentStep} updateStep={updateStep}></StepNavigation>
      <p>Etapa: {currentStep}</p>
      
     
    </div>
  );
}

export default PedidoConcluido;
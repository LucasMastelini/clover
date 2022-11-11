import React, {useState} from 'react';
import StepNavigation from './components/StepNavigation';
import './style.css';
import logoPedido from "../../assets/image/logo-caixa-produto.png"

function PedidoRealizado() {

    const labelArray = ['Recebido', 'Aprovado', 'Enviado', 'Em Trânsito', 'Entregue']
    const [currentStep, updateCurrentStep] = useState(1);
  
    function updateStep(step) {
      updateCurrentStep(step);
    }

  
    return (
      <div className='controleGeral'>
      <div className="App">
      <img className="icone" src={logoPedido} alt="Logo"></img>
      <h1 className="titulo_produto">Pedido Recebido</h1>
      <div className="descricao_geral">
      <p className="texto_descricao_subtitulo">Olá, <strong>*NOME*!</strong> Tudo bem?</p>
      <p className="texto_descricao_produto">Seu pedido  <strong>UCISADDASDAS</strong> foi recebido com sucesso.</p>
      <p className="texto_descricao_produto_2">Obrigado por escolher a Clover. É muito bom ter você aqui!</p> 
  
      </div>
  
        <StepNavigation labelArray={labelArray} currentStep={currentStep} updateStep={updateStep}></StepNavigation>
        
       
      </div>
      </div>
    );
  }

  export default PedidoRealizado;


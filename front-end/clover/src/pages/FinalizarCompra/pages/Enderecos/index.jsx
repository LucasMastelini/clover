import React from 'react'
import { BsHouseDoor, BsHouseFill } from 'react-icons/bs'
import { IMaskInput } from 'react-imask';
import OpcoesCadastradas from '../../components/OpcoesCadastradas';
import OpcoesFrete from '../../components/OpcoesFrete';
import "./style.css";

export default function Enderecos() {
  return (
    <>
        <div className="container-endereco">
            <div className="titulo-endereco">
                <BsHouseDoor/>
                <h3>Endereço</h3>
            </div>

            <div className="cep-endereco">
                <p>CEP</p>
                <IMaskInput className="input-endereco" type="text" name="" id="" mask="00000-000" placeholder="Insira o CEP"/>
                <a href='https://buscacepinter.correios.com.br/app/endereco/index.php' 
                    target="_blank" rel="noopener noreferrer" 
                    className="ajuda-cep">
                    Não sei meu CEP
                </a>
            </div>

            <h3>Formas de Entrega</h3>

            <OpcoesFrete/>

            <h3>Endereço de entrega</h3>            
            
            <OpcoesCadastradas 
                logradouro={"Avenida Rosa Fioravante"} 
                number={189} 
                cep={"CEP: 09862-305"}
                cidade={"São Bernardo do Campo"}
                uf={"SP"}
            />

            <div className="card-endereco">
                <BsHouseFill/>
                <div className="corpo-card-endereco">
                    <p>Avenida Rosa Fioravante - São Bernardo do Campo - SP</p>
                    <button>Alterar</button>
                </div>
            </div>

            <form action="" className="dados-complementares">
                <div className="dados-residenciais">
                    <div className="box">
                        <h4>Número</h4>
                        <input type="number" name="" id="" />
                    </div>
                    
                    <div className="box">
                        <h4>Complemento e referência</h4>
                        <input type="text" name="" id="" />
                    </div>
                </div>
                <div className="box">
                    <h4>Destinatário</h4>
                    <input type="text" name="" id="" />
                </div>
                <button className="btn-salvar-dados">Salvar</button>
            </form>
        </div>
    </>
  )
}

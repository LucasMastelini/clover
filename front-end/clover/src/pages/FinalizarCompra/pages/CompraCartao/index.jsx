import React, { useState } from 'react'
import { FcSimCardChip } from "react-icons/fc"
import { FaCcVisa, FaCcMastercard, FaCcDiscover } from "react-icons/fa"
import { SiAmericanexpress } from "react-icons/si"
import { useMercadopago } from 'react-sdk-mercadopago';


import "./style.css";

export default function CompraCartao({setarPassos, passoAtual}) {

    const [numberCard, setNumberCard] = useState("");
    const [nameCard, setNameCard] = useState("");
    const [mesVencimento, setMesVencimento] = useState("");
    const [anoVencimento, setAnoVencimento] = useState("");
    const [cvv, setCvv] = useState("");
    const [virarCartao, setVirarCartao] = useState(false);
    const mercadopago = useMercadopago.v1('TEST-a1503a78-1a1f-4e02-80c9-1f61ed2cc515');

    function rotate() {
        setVirarCartao(true);
    }

    function rotateLeave() {
        setVirarCartao(false);
    }

    function enviarDados() {
        setarPassos(passoAtual + 1);
    }
    
    const cardForm = mp.cardForm({
        amount: "100.5",
        iframe: true,
        form: {
          id: "form-checkout",
          cardNumber: {
            id: "form-checkout__cardNumber",
            placeholder: "Número do cartão",
          },
          expirationDate: {
            id: "form-checkout__expirationDate",
            placeholder: "MM/YY",
          },
          securityCode: {
            id: "form-checkout__securityCode",
            placeholder: "Código de segurança",
          },
          cardholderName: {
            id: "form-checkout__cardholderName",
            placeholder: "Titular do cartão",
          },
          issuer: {
            id: "form-checkout__issuer",
            placeholder: "Banco emissor",
          },
          installments: {
            id: "form-checkout__installments",
            placeholder: "Parcelas",
          },        
          identificationType: {
            id: "form-checkout__identificationType",
            placeholder: "Tipo de documento",
          },
          identificationNumber: {
            id: "form-checkout__identificationNumber",
            placeholder: "Número do documento",
          },
          cardholderEmail: {
            id: "form-checkout__cardholderEmail",
            placeholder: "E-mail",
          },
        },
        callbacks: {
          onFormMounted: error => {
            if (error) return console.warn("Form Mounted handling error: ", error);
            console.log("Form mounted");
          },
          onSubmit: event => {
            event.preventDefault();
  
            const {
              paymentMethodId: payment_method_id,
              issuerId: issuer_id,
              cardholderEmail: email,
              amount,
              token,
              installments,
              identificationNumber,
              identificationType,
            } = cardForm.getCardFormData();
  
            fetch("/process_payment", {
              method: "POST",
              headers: {
                "Content-Type": "application/json",
              },
              body: JSON.stringify({
                token,
                issuer_id,
                payment_method_id,
                transaction_amount: Number(amount),
                installments: Number(installments),
                description: "Descrição do produto",
                payer: {
                  email,
                  identification: {
                    type: identificationType,
                    number: identificationNumber,
                  },
                },
              }),
            });
          },
          onFetching: (resource) => {
            console.log("Fetching resource: ", resource);
  
            // Animate progress bar
            const progressBar = document.querySelector(".progress-bar");
            progressBar.removeAttribute("value");
  
            return () => {
              progressBar.setAttribute("value", "0");
            };
          }
        },
      });
      
  return (
    <>
        <div className="container-compra">

            <div className="card-container">

                <div className="front">
                    <div className="icones-cartao">
                        <FcSimCardChip/>
                        {/* {numberCard.substring(0,2) === "37" ? (<SiAmericanexpress/>) : (<FaCcVisa/>)}
                        {numberCard.substring(0,2) === "44" ? (<FaCcVisa/>) : (<FaCcVisa/>)} */}
                        {numberCard.substring(0,2) === "55" ? (<FaCcMastercard/>) : (<FaCcVisa/>)}
                        {/* {numberCard.substring(0,2) === "66" ? (<FaCcDiscover/>) : (<FaCcVisa/>)} */}
                        
                    </div>
                    <input className="card-number-box" placeholder='#### #### #### ####' 
                        defaultValue={numberCard} 
                        onChange={event => { setNumberCard(event.target.value)}} disabled={true}/>
                    <div className="flexbox">
                        <div className="box">
                            <span>titular cartão</span>
                            <input defaultValue={nameCard} 
                                onChange={event => {setNameCard(event.target.value)}} 
                                className="card-holder-name" placeholder="nome completo" disabled={true}/>
                        </div>
                        <div className="box">
                            <span>expiração</span>
                            <div className="card-holder-name">
                                <input defaultValue={mesVencimento} 
                                    onChange={event => {setMesVencimento(event.target.value)}} 
                                    className="exp-month" placeholder='mês' disabled={true}/>
                                <input defaultValue={anoVencimento} 
                                    onChange={event => {setAnoVencimento(event.target.value)}} 
                                    className="exp-year" placeholder="ano" disabled={true}/>
                            </div>
                        </div>
                    </div>
                </div>

                <div className={ virarCartao ? "back" : ""}>
                    <div className="stripe"></div>
                    <div className="box">
                        <span>cvv</span>
                        <input className="cvv-box" 
                            disabled={true} 
                            value={cvv} 
                            onChange={event => {setCvv(event.target.value)}}/>
                        <FaCcVisa/>
                    </div>
                </div>

            </div>
            
            <form action="" method="post" className="formulario">
                <div className="input-box">
                    <span>número do cartão</span>
                    <input type="number" min={16} max={16} 
                        defaultValue={numberCard} 
                        onChange={event => {setNumberCard(event.target.value)}} 
                        name="" id="" 
                        className="card-holder-input"
                    />
                </div>
                <div className="input-box">
                    <span>titular do cartão</span>
                    <input type="text" defaultValue={nameCard} 
                        onChange={event => {setNameCard(event.target.value)}} 
                        name="" id="" 
                        className="card-holder-input"
                    />
                </div>
                <div className="flexbox">
                    <div className="input-box">
                        <span>mês expiração</span>
                        <select name="" defaultValue={mesVencimento} 
                            onChange={event => {setMesVencimento(event.target.value)}}  
                            id="" className="month-input">
                            <option defaultValue="month">mês</option>
                            <option defaultValue="01">janeiro</option>
                            <option defaultValue="02">fevereiro</option>
                            <option defaultValue="03">março</option>
                            <option defaultValue="04">abril</option>
                            <option defaultValue="05">maio</option>
                            <option defaultValue="06">junho</option>
                            <option defaultValue="07">julho</option>
                            <option defaultValue="08">agosto</option>
                            <option defaultValue="09">setembro</option>
                            <option defaultValue="10">outubro</option>
                            <option defaultValue="11">novembro</option>
                            <option defaultValue="12">dezembro</option>
                        </select>
                    </div>
                    <div className="input-box">
                        <span>ano expiração</span>
                        <select name="" defaultValue={anoVencimento} 
                            onChange={event => {setAnoVencimento(event.target.value)}} 
                            id="" 
                            className="year-input">
                            <option defaultValue="year">ano</option>
                            <option defaultValue="2022">2022</option>
                            <option defaultValue="2023">2023</option>
                            <option defaultValue="2024">2024</option>
                            <option defaultValue="2025">2025</option>
                            <option defaultValue="2026">2026</option>
                            <option defaultValue="2027">2027</option>
                            <option defaultValue="2028">2028</option>
                            <option defaultValue="2029">2029</option>
                            <option defaultValue="2030">2030</option>
                        </select>
                    </div>
                    <div className="input-box">
                        <span>cvv</span>
                        <input
                            type="text"
                            onMouseEnter={rotate}
                            onMouseLeave={rotateLeave} 
                            defaultValue={cvv} 
                            onChange={event => {setCvv(event.target.value)}} 
                            maxLength={4} className="cvv-input" name="" id="" />
                    </div>
                </div>
                <div className="input-box">
                    <span>quantidade de parcelas</span>
                    <input type="text" defaultValue="" 
                        name="" id="" 
                        className="card-holder-input"
                    />
                </div>
                
                <button type="submit" defaultValue="submit"  className="submit-btn">
                    Finalizar pedido
                </button>
            </form>
        </div>
    </>
  )
}

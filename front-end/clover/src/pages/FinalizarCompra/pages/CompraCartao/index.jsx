import React, { useState } from 'react'
import { FcSimCardChip } from "react-icons/fc"
import { FaCcVisa, FaCcMastercard } from "react-icons/fa"


import "./style.css";

export default function CompraCartao() {

    const [numberCard, setNumberCard] = useState("");
    const [nameCard, setNameCard] = useState("");
    const [mesVencimento, setMesVencimento] = useState("");
    const [anoVencimento, setAnoVencimento] = useState("");
    const [cvv, setCvv] = useState("");
    const [virarCartao, setVirarCartao] = useState(false); 

    function rotate() {
        setVirarCartao(true);
        document.getElementsByClassName('.front').style.transform = `perspective(1000px) rotateY(0deg)`;
        document.getElementsByClassName('.back').style.transform = `perspective(1000px) rotateY(180deg)`;
    }

    function rotateLeave() {
        setVirarCartao(false);
        document.getElementsByClassName('.front').style.transform = `perspective(1000px) rotateY(-180deg)`;
        document.getElementsByClassName('.back').style.transform = `perspective(1000px) rotateY(0deg)`;
    }

  return (
    <>
        <div className="container-compra">

            <div className="card-container">

                <div className="front" value={virarCartao}>
                    <div className="icones-cartao">
                        <FcSimCardChip/>
                        <FaCcVisa/>
                    </div>
                    <input className="card-number-box" placeholder='#### #### #### ####' value={numberCard} onChange={event => { setNumberCard(event.target.value)}} disabled={true}/>
                    <div className="flexbox">
                        <div className="box">
                            <span>titular cartão</span>
                            <input value={nameCard} onChange={event => {setNameCard(event.target.value)}} className="card-holder-name" placeholder="nome completo" disabled={true}/>
                        </div>
                        <div className="box">
                            <span>expiração</span>
                            <div className="card-holder-name">
                                <input value={mesVencimento} onChange={event => {setMesVencimento(event.target.value)}} className="exp-month" placeholder='mês' disabled={true}/>
                                <input value={anoVencimento} onChange={event => {setAnoVencimento(event.target.value)}} className="exp-year" placeholder="ano" disabled={true}/>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="back" value={virarCartao}>
                    <div className="stripe"></div>
                    <div className="box">
                        <span>cvv</span>
                        <input className="cvv-box" disabled={true} value={cvv} onChange={event => {setCvv(event.target.value)}}/>
                        <FaCcVisa/>
                    </div>
                </div>

            </div>
            
            <form action="" method="post" className="formulario">
                <div className="input-box">
                    <span>número do cartão</span>
                    <input type="number" max={16} value={numberCard} onChange={event => {setNumberCard(event.target.value)}} name="" id="" className="card-holder-input"/>
                </div>
                <div className="input-box">
                    <span>titular do cartão</span>
                    <input type="text" value={nameCard} onChange={event => {setNameCard(event.target.value)}} name="" id="" className="card-holder-input"/>
                </div>
                <div className="flexbox">
                    <div className="input-box">
                        <span>mês expiração</span>
                        <select name="" value={mesVencimento} onChange={event => {setMesVencimento(event.target.value)}}  id="" className="month-input">
                            <option value="month" selected disabled>month</option>
                            <option value="01">janeiro</option>
                            <option value="02">fevereiro</option>
                            <option value="03">março</option>
                            <option value="04">abril</option>
                            <option value="05">maio</option>
                            <option value="06">junho</option>
                            <option value="07">julho</option>
                            <option value="08">agosto</option>
                            <option value="09">setembro</option>
                            <option value="10">outubro</option>
                            <option value="11">novembro</option>
                            <option value="12">dezembro</option>
                        </select>
                    </div>
                    <div className="input-box">
                        <span>ano expiração</span>
                        <select name="" value={anoVencimento} onChange={event => {setAnoVencimento(event.target.value)}} id="" className="year-input">
                            <option value="year" selected disabled>year</option>
                            <option value="2022">2022</option>
                            <option value="2023">2023</option>
                            <option value="2024">2024</option>
                            <option value="2025">2025</option>
                            <option value="2026">2026</option>
                            <option value="2027">2027</option>
                            <option value="2028">2028</option>
                            <option value="2029">2029</option>
                            <option value="2030">2030</option>
                        </select>
                    </div>
                    <div className="input-box">
                        <span>cvv</span>
                        <input type="text" onMouseEnter={rotate} onMouseLeave={rotateLeave} value={cvv} onChange={event => {setCvv(event.target.value)}} maxLength={4} className="cvv-input" name="" id="" />
                    </div>
                </div>
                <input type="submit" value="submit"  className="submit-btn"/>
            </form>
        </div>
    </>
  )
}

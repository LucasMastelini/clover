import React from 'react'
import './sidebar.css';
import { FaRegUserCircle, FaTshirt, FaCity, FaAddressCard } from 'react-icons/fa'
import { BsFillCreditCardFill } from 'react-icons/bs'

function SideBar() {

    return (
        <>
            <div className="container-principal">
                <div className="welcome">
                    <FaRegUserCircle className="user" /> <p className="welcome-user-text">Olá, Barreira!</p>
                </div>
                <div className="option">
                    <FaTshirt className="icon" /><p className="icon-title">Pedidos</p>
                </div>
                <div className="option">
                    <BsFillCreditCardFill className="icon" /><p className="icon-title">Cartões</p>
                </div>
                <div className="option">
                <FaAddressCard className="icon" /><p className="icon-title">Dados Pessoais</p>
                </div>
                <div className="option">
                    <FaCity className="icon" /><p className="icon-title">Endereços</p>
                </div>
                <div className="option">
                    <FaTshirt className="icon" /><p className="icon-title">Sair</p>
                </div>
            </div>
        </>
    )
}

export default SideBar;

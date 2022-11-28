import React from 'react'
import './style.css'
import spiderman from './images/spiderman.jpg'
import { useState } from 'react';
import Modal from 'react-modal';

function CardPedidos() {

    const [modalIsOpen, setIsOpen] = useState(false);

    const [destinatario] = useState("Julia");
    const [pedido] = useState("UC1111111P");
    const [tituloPedido] = useState("Camiseta Spiderman - Beyond Dimensions")

    function handleOpenModal() {
        setIsOpen(true);
    }

    function handleCloseModal() {
        setIsOpen(false);
    }

    const bg = {
        overlay: {
            backgroundColor: "rgba(0, 0, 0, 0.468)"
        }
    }

    return (
        <>
            <div className='container-card'>
                <div className="card">
                    <div className="pedidos-esquerda">
                        <img src={spiderman} />
                        <div className="infos-pedidos">
                            <div className="item-pedido">
                                <p className="pedido-titulo">Pedido:</p>
                                <p className="pedido-numero">{pedido}</p>
                            </div>
                            <p className="pedido-destinatario">Destinatario: {destinatario}</p>
                            <p className="pedido-detalhes" onClick={handleOpenModal}>Detalhes</p>
                        </div>
                    </div>
                    <div className="pedidos-direita">
                        <div className='data-pedido'>
                            <p className="data-titulo">Data de entrega:</p>
                            <p className="data">14/11/2022</p>
                        </div>
                    </div>
                </div>
            </div>
            <Modal
                className="modal"
                isOpen={modalIsOpen}
                onRequestClose={handleCloseModal}
                style={bg}>
            <div className="modal-container">
                <div className="modal-lado-esquerdo">
                    <h2 className="numero-titulo-pedido">Pedido {pedido}</h2>
                    <div className="titulo-pedido">{tituloPedido}</div>
                    <img src={spiderman} />
                </div>
                <button className="fechar" onClick={handleCloseModal}>X</button>
            </div>
        </Modal>
        </>
    )
}

export default CardPedidos;


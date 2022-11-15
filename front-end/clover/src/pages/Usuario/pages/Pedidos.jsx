import React from 'react'
import Header from '../../Header'
import SideBar from '../Sidebar/SideBar';
import './style-pedidos.css'
import Spiderman from './images/spiderman.jpg'

function Pedidos() {
  return (
    <>
      <Header />
      <div className="container-geral">
        <SideBar></SideBar>
        <div className="container-pedidos">
          <div className="pedidos">
            <div className="card">
              <img src={Spiderman} />
              <div className="infos-pedidos">
                <div className="item-pedido">
                  <p className="pedido-titulo">Pedido:</p>
                  <p className="pedido-numero">UC1111111P</p>
                </div>
                <p className="pedido-titulo">Destinatario: Julia</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Pedidos;

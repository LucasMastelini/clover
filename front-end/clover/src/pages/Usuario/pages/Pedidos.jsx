import React from 'react'
import Header from '../../Header'
import SideBar from '../Sidebar/SideBar';
import './style-pedidos.css'
import CardPedidos from './CardPedidos/CardPedidos';

function Pedidos() {

  return (
    <>
      <Header />
      <div className="container-geral">
        <SideBar></SideBar>
        <div className="container-pedidos">
          <CardPedidos />
        </div>
      </div>
    </>
  )
}

export default Pedidos;

import React from 'react'
import Header from '../../Header'
import SideBar from '../Sidebar/SideBar';
import './style-pedidos.css'
import CardPedidos from './CardPedidos/CardPedidos';

function Pedidos() {

  return (
    <>
      <div className="container-geral">
        <div className="container-pedidos">
          <CardPedidos />
        </div>
      </div>
    </>
  )
}

export default Pedidos;

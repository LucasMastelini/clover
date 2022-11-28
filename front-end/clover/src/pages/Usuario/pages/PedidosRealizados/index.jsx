import React from 'react'
import './style.css'
import CardPedidos from '../CardPedidos';

function PedidosRealizados() {

  return (
    <>
      <div className="container-geral-pedidos">
        <div className="container-pedidos">
          <CardPedidos />
        </div>
      </div>
    </>
  )
}

export default PedidosRealizados;

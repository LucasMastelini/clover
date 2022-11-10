import React from 'react'
import { Routes, Route } from 'react-router-dom'
import HomePage from '../pages/HomePage'
import QuemSomos from '../pages/QuemSomos'
import CadastroLogin from '../pages/CadastroLogin'
import CompraProduto from '../pages/CompraProduto'
// import PedidoRealizado from '../pages/PedidoRealizado'
export default function Router() {
  return (
      <Routes>
        <Route path="/" element={<HomePage/>}/>
        <Route path="/quem-somos" element={<QuemSomos/>}/>
        <Route path="/cadastro-login" element={<CadastroLogin/>}/>
        <Route path="/cadastro-login" element={<CompraProduto/>}/>
        {/* <Route path="/cadastro-login" element={<PedidoRealizado/>}/> */}
        {/* <Route path="/compra-produto" element={<CompraProduto/>}/> */}
        {/* <Route path="/resumo-pedidos/:produtos" element={<ResumoPedidos />} /> */}
      </Routes>
  )
}

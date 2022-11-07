import React from 'react'
import { Routes, Route } from 'react-router-dom'
import HomePage from '../pages/HomePage'
import QuemSomos from '../pages/QuemSomos'
import Usuario from '../pages/Usuario'
import CadastroLogin from '../pages/CadastroLogin'
import Carrinho from '../pages/Carrinho'
// import CompraProduto from '../pages/CompraProduto'

export default function Router() {
  return (
      <Routes>
        <Route path="/" element={<HomePage/>}/>
        <Route path="/quem-somos" element={<QuemSomos/>}/>
        <Route path="/cadastro-login" element={<CadastroLogin/>}/>
        <Route path="/usuario" element={<Usuario/>}/>
        <Route path="/carrinho" element={<Carrinho/>}/>
        {/* <Route path="/compra-produto" element={<CompraProduto/>}/> */}
        {/* <Route path="/resumo-pedidos/:produtos" element={<ResumoPedidos />} /> */}
      </Routes>
  )
}

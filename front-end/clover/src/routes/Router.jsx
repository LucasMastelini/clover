import React from 'react'
import { Routes, Route } from 'react-router-dom'
import HomePage from '../pages/HomePage'
import QuemSomos from '../pages/QuemSomos'
import Usuario from '../pages/Usuario'
import CadastroLogin from '../pages/CadastroLogin'
import CompraProduto from '../pages/CompraProduto'
import PedidoRealizado from '../pages/PedidoRealizado'
import Carrinho from '../pages/Carrinho'

import Users from '../pages/Usuario/pages/Users'
import Cartoes from '../pages/Usuario/pages/Cartoes'
import DadosPessoais from '../pages/Usuario/pages/DadosPessoais'
import Enderecos from '../pages/Usuario/pages/Enderecos'
import Sair from '../pages/Usuario/pages/Sair'

export default function Router() {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/quem-somos" element={<QuemSomos />} />
      <Route path="/cadastro-login" element={<CadastroLogin />} />
      <Route path="/compra-produto" element={<CompraProduto />} />
      <Route path="/pedido-realizado" element={<PedidoRealizado />} />
      <Route path="/usuario" element={<Usuario />} />
      <Route path="/carrinho" element={<Carrinho />} />
      <Route path="/users" element={<Users />} />
      <Route path="/cartoes" element={<Cartoes />} />
      <Route path="/dados-pessoais" element={<DadosPessoais />} />
      <Route path="/enderecos" element={<Enderecos />} />
      <Route path="/sair" element={<Sair />} />
      {/* <Route path="/resumo-pedidos/:produtos" element={<ResumoPedidos />} /> */}
    </Routes>
  )
}

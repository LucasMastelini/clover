import React from "react";
import { Routes, Route } from "react-router-dom";
import HomePage from "../pages/HomePage";
import QuemSomos from "../pages/QuemSomos";
import Usuario from "../pages/Usuario";
import CadastroLogin from "../pages/CadastroLogin";
import CompraProduto from "../pages/CompraProduto";
import PedidoRealizado from "../pages/PedidoRealizado";
import Carrinho from "../pages/Carrinho";
import { CarrinhoProvider } from "../pages/Carrinho/Context";
import FinalizarCompra from '../pages/FinalizarCompra'

export default function Router() {
  return (
    <CarrinhoProvider>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/quem-somos" element={<QuemSomos />} />
        <Route path="/cadastro-login" element={<CadastroLogin />} />
        <Route path="/compra-produto" element={<CompraProduto />} />
        <Route path="/pedido-realizado" element={<PedidoRealizado />} />
        <Route path="/usuario" element={<Usuario />} />
        <Route path="/carrinho" element={<Carrinho />} />
        <Route path="/finalizar-compra" element={<FinalizarCompra/>} />
        {/* <Route path="/resumo-pedidos/:produtos" element={<ResumoPedidos />} /> */}
      </Routes>
    </CarrinhoProvider>
  );
}

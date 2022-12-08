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
import Filtros from "../pages/Filtros";
import Erro404 from "../pages/Erro404";
import TelaAdmin from "../pages/TelaAdmin";
import FinalizarCompraDois from "../pages/FinalizarCompra/pages/FinalizarCompraDois";
import FinalizarCompraTres from "../pages/FinalizarCompra/pages/FinalizarCompraTres";
import FinalizarCompraQuatro from "../pages/FinalizarCompra/pages/FinalizarCompraQuatro";
// import Teste from "../pages/NotFound/teste";

export default function Router() {
  return (
    <CarrinhoProvider>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/quem-somos" element={<QuemSomos />} />
        <Route path="/cadastro-login" element={<CadastroLogin />} />
        <Route path="/compra-produto" element={<CompraProduto />} />
        <Route path="/filtros" element={<Filtros />} />
        <Route path="/pedido-realizado" element={<PedidoRealizado />} />
        <Route path="/usuario" element={<Usuario />} />
        <Route path="/carrinho" element={<Carrinho />} />
        <Route path="/finalizar-compra" element={<FinalizarCompra/>} />
        <Route path="/finalizar-compra-dois" element={<FinalizarCompraDois/>} />
        <Route path="/finalizar-compra-tres" element={<FinalizarCompraTres/>} />
        <Route path="/finalizar-compra-quatro" element={<FinalizarCompraQuatro/>} />
        <Route path="/*" element={<Erro404/>} />
        <Route path="/admin" element={<TelaAdmin/>} />
        {/* <Route path="/resumo-pedidos/:produtos" element={<ResumoPedidos />} /> */}
      </Routes>
    </CarrinhoProvider>
  );
}

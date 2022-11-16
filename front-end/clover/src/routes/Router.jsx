import React from "react";
import { Routes, Route } from "react-router-dom";
import HomePage from "../pages/HomePage";
import QuemSomos from "../pages/QuemSomos";
import Usuario from "../pages/Usuario";
import CadastroLogin from "../pages/CadastroLogin";
import CompraProduto from "../pages/CompraProduto";
import PedidoRealizado from "../pages/PedidoRealizado";
import Carrinho from "../pages/Carrinho";

import Pedidos from "../../src/pages/Usuario/pages/Pedidos";
import Cartoes from "../../src/pages/Usuario/pages/Cartoes";
import DadosPessoais from "../../src/pages/Usuario/pages/DadosPessoais";
import Enderecos from "../../src/pages/Usuario/pages/Enderecos";
import Sair from "../../src/pages/Usuario/pages/Sair";
import { CarrinhoProvider } from "../pages/Carrinho/Context";


export default function Router() {
  return (
    <CarrinhoProvider>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/quem-somos" element={<QuemSomos />} />
        <Route path="/cadastro-login" element={<CadastroLogin />} />
        <Route path="/compra-produto" element={<CompraProduto />} />
        <Route path="/pedido-realizado" element={<PedidoRealizado />} />
        <Route path="/pedidos" element={<Pedidos />} />
        <Route path="/usuario" element={<Usuario />} />
        <Route path="/carrinho" element={<Carrinho />} />
        <Route path="/cartoes" element={<Cartoes />} />
        <Route path="/dados-pessoais" element={<DadosPessoais />} />
        <Route path="/enderecos" element={<Enderecos />} />
        <Route path="/sair" element={<Sair />} />
        {/* <Route path="/resumo-pedidos/:produtos" element={<ResumoPedidos />} /> */}
      </Routes>
    </CarrinhoProvider>
  );
}

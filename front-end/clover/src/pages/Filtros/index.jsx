import React from "react";
import { useNavigate } from "react-router-dom";
import CardProduto from "../../components/CardProduto";
import Footer from "../../components/Footer";
import Header from "../Header";
import NumeradorPaginas from "./NumeradorPaginas";

import "./style.css";
export default function Filtros() {
  const navigate = useNavigate();

  return (
    <>
      <Header />
      <div className="container-filtros">
        <div className="direcionamento-paginas">
          <h4 onClick={() => navigate("/")}>Home</h4>
          <div className="bolinha"></div>
          <h4 className="tela-atual">Animes</h4>
        </div>

        <NumeradorPaginas/>
        
        <div className="corpo-tela-filtros">
          <CardProduto />
          <CardProduto />
          <CardProduto />
          <CardProduto />
          <CardProduto />
          <CardProduto />
          <CardProduto />
          <CardProduto />
          <CardProduto />
          <CardProduto />
          <CardProduto />
          <CardProduto />
        </div>
      </div>
      <Footer />
    </>
  );
}

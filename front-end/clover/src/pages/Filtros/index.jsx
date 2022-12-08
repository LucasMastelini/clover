import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../Api/api";
import CardProduto from "../../components/CardProduto";
import Footer from "../../components/Footer";
import Header from "../Header";
import NumeradorPaginas from "./NumeradorPaginas";

import "./style.css";
export default function Filtros() {
  const navigate = useNavigate();
  const [itens , setItens] = useState({});

  useEffect(() =>{
    api.get('/produtos?subcategorias=2')
    .then(res =>{
      // console.log(res);
      setItens(res.data);
    })
    .catch(erro => {
    })

  },[])
  console.log(itens);


  return (
    <>
      <Header />
      <div className="container-filtros">
        <div className="direcionamento-paginas">
          <h4 onClick={() => navigate("/")}>Home</h4>
          <div className="bolinha"></div>
          <h4 className="tela-atual">Animes</h4>
        </div>

        <NumeradorPaginas caunt={5}/>
        
        <div className="corpo-tela-filtros">
          {itens.content?.map((produto) => {
            <CardProduto 
            nome={produto.nome}
            preco={produto.preco}
             />
          }) }
        </div>
      </div>
      <Footer />
    </>
  );
}

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
    api.get('/produtos?categorias=1')
    .then(res =>{
      console.log(res);
      setItens(res);
    })
    .catch(erro => {
    })

  },[])
  // console.log(itens);


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
          {itens.data ? <CardProduto/>:<CardProduto/> }
        </div>
      </div>
      <Footer />
    </>
  );
}

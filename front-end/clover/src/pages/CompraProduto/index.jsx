import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import ContainerCompra from "./components/ContainerCompra";
import ContainerDescricao from "./components/ContainerDescricao";
import CarrosselCards from "../../components/CarroselCards";
import CardProduto from "../../components/CardProduto";
import Header from "../Header";
import Footer from "../../components/Footer";
import api from "../../Api/api";

import './style.css';

function CompraProduto() {

    const [itens, setItens] = useState({});

    useEffect(() => {
     setItens(JSON.parse(localStorage.getItem('itens-filtro')))
    }, [])
    console.log(itens);

    return (
        <>
        <Header/>
            <ContainerCompra />
            <h2 className="title-carrossel">{itens.content?.map((produto) => {
                if(produto.id === 5){
                    return(

                         produto.subtitulo          
                        )
                }
                
            })}</h2>
            <div className="container-descricao-produto">
                <p>
                    {itens.content?.map((produto) => 
                    {
                        if(produto.id === 5){
                            return(
        
                                 produto.descricao         
                                )
                        }
                    })}
                </p>
            </div>
            <ContainerDescricao />
            <h2 className="title-carrossel">O QUE OUTROS CLIENTES TAMBÉM COMPRARAM</h2>
            <CarrosselCards>
            {itens.content?.map((produto) => {
            return (<CardProduto
              nome={produto.nome}
              preco={produto.preco}
              precoSimulado={produto.preco}
            />)
          })}
            </CarrosselCards>
            <Footer/>
        </>

    );
}

export default CompraProduto;
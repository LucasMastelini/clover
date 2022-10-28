import React from "react";

import Colection from "./components/Colection";
import Oferts from "./components/Oferts";
import Slider from "./components/Slider";
import CarroselCards from "../../components/CarroselCards";
import Collab from "./components/Collab";
import Comment from "./components/Comment";
import CardProduto from "../../components/CardProduto";
import RedesSociais from "../../components/RedesSociais";
import Header from "../Header";
import Footer from "../../components/Footer";

import "./style.css";

function HomePage() {
  return (
    <>
      <Header></Header>
      <Slider></Slider>

      <div className="line-style"></div>

      <Oferts></Oferts>

      <div className="line-style"></div>

      <h2 className="title-home">NOSSAS COLEÇÕES</h2>

      <Colection></Colection>

      <div className="line-style"></div>

      <h2 className="title-home">NOSSOS PARCEIROS</h2>

      <CarroselCards>
        <Collab></Collab>
      </CarroselCards>

      <h2 className="title-home">LANÇAMENTOS PARA O CLOVER LOVERS</h2>

      <CarroselCards>
        <CardProduto></CardProduto>
        <CardProduto></CardProduto>
        <CardProduto></CardProduto>
        <CardProduto></CardProduto>
        <CardProduto></CardProduto>
        <CardProduto></CardProduto>
      </CarroselCards>

      <div className="line-style"></div>

      <h2 className="title-home">
        VEJA O QUE OS NOSSOS CLOVER LOVER FALAM DA NOSSA LOJA
      </h2>

      <CarroselCards>
        <Comment />
      </CarroselCards>

      <div className="line-style"></div>

      <RedesSociais />
      <Footer />
    </>
  );
}

export default HomePage;

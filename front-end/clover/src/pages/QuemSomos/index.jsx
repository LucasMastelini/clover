import React from 'react'

import CardProduto from '../../components/CardProduto';
import RedesSociais from '../../components/RedesSociais';
import Footer from "../../components/Footer";
import Header from '../Header';

import mocaSpock from '../../assets/image/moca-spock.png'
import mocoGamer from '../../assets/image/moco-gamer.png'

import { FaBalanceScale } from "react-icons/fa";
import { GiArcheryTarget } from "react-icons/gi";
import { BsFillLightbulbFill, BsPersonCircle, BsLinkedin } from "react-icons/bs";

import './style.css';

function QuemSomos() {
  return (
    <>
      <Header></Header>
      <main>
        <section className="quem-somos">
          <div className="img-qmSomos">
            <img src={mocaSpock} alt="" />
          </div>
          <div className="titulo-principal">
            <h1>Quem somos</h1>
          </div>
        </section>

        <section className="agradecimento">
          <div className="text-agradecimento">
            <h3 className="titulo-padrao1">Criado pro geek em você!</h3>
            <p className="texto1">Em 2022, começou a lenda de um portal mágico, criado por magos apaixonados por tecnologia e entretenimento geek.
              O experimento iniciado em uma academia de magia, onde cada linha de código materializava parte de um sonho, se tornou um propósito que vai de encontro ao seu estilo, do jeito que você sempre sonhou!
              A moda e os acessórios online que te espelham!</p>
          </div>
          <div className="img-agradecimento">
            <img src={mocoGamer} alt="" />
          </div>
        </section>

        <div className="line-style"></div>

        <section className="identidade-visual">
          <CardProduto></CardProduto>
          <div className="text-ident-visual">
            <h3 className="titulo-padrao1">identidade visual</h3>
            <p className="texto1">
              Aqui na Clover’s nos preocupamos com a ambientação e com deixar nossos fãclovers a vontade.
              Pra tudo isso acontecer, nada mais justo que manter
            </p>
          </div>
        </section>

        <div className="line-style"></div>

        <section className="sobre-nos">
          <h3 className="titulo-padrao1"> Sobre nós</h3>
          <div className="container-sobre-card">
            <div className="sobre-card">
              <div className="sc-cabecalho scard-rosa"></div>
              <div className="sc-icon scard-rosa-icon">
                <GiArcheryTarget/>
              </div>
              <div className="sc-texto scard-rosa-icon">
                <p>Missão</p>
              </div>
              <div className="sc-texto">
                <p className="texto2">
                  Utilizar a jóia do espaço para transportar
                  o geek a um lugar fantástico do universo que contém o estilo
                  e os acessórios perfeitos para ele.
                </p>
              </div>
            </div>
            <div className="sobre-card">
              <div className="sc-cabecalho scard-verde"></div>
              <div className="sc-icon scard-verde-icon">
                <BsFillLightbulbFill/>
              </div>
              <div className="sc-texto scard-verde-icon">
                <p>Visão</p>
              </div>
              <div className="sc-texto">
                <p className="texto2">
                  Alcançar as jóias restantes para se tornar uma referência
                  extraordinária de poder em variedade de estilos e jornada de utilização.
                </p>
              </div>
            </div>
            <div className="sobre-card">
              <div className="sc-cabecalho scard-azul"></div>
              <div className="sc-icon scard-azul-icon">
                <FaBalanceScale/>
              </div>
              <div className="sc-texto scard-azul-icon">
                <p>Valores</p>
              </div>
              <div className="sc-texto">
                <p className="texto2">
                  Imaginação <br />
                  Diversão<br />
                  Transparência<br />
                  Pluralidade<br />
                  Orgulho
                </p>
              </div>
            </div>
          </div>
        </section>

        <div className="line-style"></div>

        <section className="nosso-time">
          <div className="container-time">
            <h3 className="titulo-padrao1">Nossa equipe</h3>
            <div className="grid-container">
              <div className="grid-item"> </div>
              <div className="grid-item">
                <BsPersonCircle className="icon-photo"/>
                <p className="texto1"> <BsLinkedin className="texto1" name="logo-linkedin"></BsLinkedin> Brenda</p>
              </div>
              <div className="grid-item"> </div>
              <div className="grid-item">
                <BsPersonCircle className="icon-photo"/>
                <p className="texto1">  <BsLinkedin className="texto1" name="logo-linkedin"></BsLinkedin> Fabio</p>
              </div>
              <div className="grid-item"></div>
              <div className="grid-item">
                <BsPersonCircle className="icon-photo"/>
                <p className="texto1">  <BsLinkedin className="texto1" name="logo-linkedin"></BsLinkedin> Gustavo</p>
              </div>
              <div className="grid-item"></div>
              <div className="grid-item"></div>
              <div className="grid-item"></div>
              <div className="grid-item">
                <BsPersonCircle className="icon-photo"/>
                <p className="texto1"><BsLinkedin className="texto1" name="logo-linkedin"></BsLinkedin> Igor</p>
              </div>
              <div className="grid-item"> </div>
              <div className="grid-item">
                <BsPersonCircle className="icon-photo"/>
                <p className="texto1"> <BsLinkedin className="texto1" name="logo-linkedin"></BsLinkedin> Lucas</p>
              </div>
              <div className="grid-item"> </div>
              <div className="grid-item">
                <BsPersonCircle className="icon-photo"/>
                <p className="texto1">
                  <BsLinkedin className="texto1" name="logo-linkedin"></BsLinkedin> Leticia</p>
              </div>
              <div className="grid-item"></div>
            </div>
          </div>
        </section>

        <div className="line-style"></div>

        <RedesSociais/>
        <Footer></Footer>
      </main>
    </>
  )
}
export default QuemSomos;
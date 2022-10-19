import React from 'react'
import { NavLink } from 'react-router-dom'
import RedesSociais from '../../components/RedesSociais';
import './style.css';


function QuemSomos() {
  return (
    <>
      <main>
        <section class="quem-somos">
          <div class="img-qmSomos">
            <img src="/images/moça-spock.png" alt="" />
          </div>
          <div class="titulo-principal">
            <h1>Quem somos</h1>
          </div>
        </section>
        <section class="agradecimento">
          <div class="text-agradecimento">
            <h3 class="titulo-padrao1">Criado pro geek em você!</h3>
            <p class="texto1">Em 2022, começou a lenda de um portal mágico, criado por magos apaixonados por tecnologia e entretenimento geek.

              O experimento iniciado em uma academia de magia, onde cada linha de código materializava parte de um sonho, se tornou um propósito que vai de encontro ao seu estilo, do jeito que você sempre sonhou!

              A moda e os acessórios online que te espelham!</p>
          </div>
          <div class="img-agradecimento">
            <img src="/images/wepik-photo-mode-2022722-115922 1.png" alt="" />
          </div>
        </section>
        <section class="identidade-visual">
          <div class="container-card">
            <div id="card" class="gradient-border">
              <img src="/images/Rectangle101.png" alt="" />
              <p class="texto1">Camiseta branca lisa - masculina </p>
              <p><span class="valor-simulado">R$84,50</span>
                <span class="valor-produto">R$79,90
                </span>
              </p>
              <p class="opcao-parcela">ou 12x de R$8,10</p>
            </div>

          </div>
          <div class="text-ident-visual">
            <h3 class="titulo-padrao1">identidade visual</h3>
            <p class="texto1">
              Aqui na Clover’s nos preocupamos com a ambientação e com deixar nossos fãclovers a vontade.
              Pra tudo isso acontecer, nada mais justo que manter
            </p>
          </div>
        </section>
        <section class="sobre-nos">
          <h3 class="titulo-padrao1"> Sobre nós</h3>
          <div class="container-sobre-card">
            <div class="sobre-card">
              <div class="sc-cabecalho scard-rosa"></div>
              <div class="sc-icon scard-rosa-icon">
                <img src="/images/icon-missão.png" alt="" />
              </div>
              <div class="sc-texto scard-rosa-icon">
                <p>Missão</p>
              </div>
              <div class="sc-texto">
                <p class="texto2">
                  Utilizar a jóia do espaço para transportar
                  o geek a um lugar fantástico do universo que contém o estilo
                  e os acessórios perfeitos para ele.
                </p>
              </div>

            </div>
            <div class="sobre-card">
              <div class="sc-cabecalho scard-verde"></div>
              <div class="sc-icon scard-verde-icon">
                <ion-icon name="bulb-outline"></ion-icon>
              </div>
              <div class="sc-texto scard-verde-icon">
                <p>Visão</p>
              </div>
              <div class="sc-texto">
                <p class="texto2">
                  Alcançar as jóias restantes para se tornar uma referência
                  extraordinária de poder em variedade de estilos e jornada de utilização.

                </p>
              </div>

            </div>
            <div class="sobre-card">
              <div class="sc-cabecalho scard-azul"></div>
              <div class="sc-icon scard-azul-icon">
                <img src="/images/icon-valores.png" alt="" />
              </div>
              <div class="sc-texto scard-azul-icon">
                <p>Valores</p>
              </div>
              <div class="sc-texto">
                <p class="texto2">
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
        <section class="nosso-time">
          <div class="container-time">
            <h3 class="titulo-padrao1">Nossa equipe</h3>
            <div class="grid-container">
              <div class="grid-item"> </div>
              <div class="grid-item">
                <img src="/images/messiCalvo.jpeg" alt="" />
                <p class="texto1"> <ion-icon class="texto1" name="logo-linkedin"></ion-icon> Brenda</p>

              </div>
              <div class="grid-item"> </div>
              <div class="grid-item">
                <img src="/images/messiCalvo.jpeg" alt="" />
                <p class="texto1">  <ion-icon class="texto1" name="logo-linkedin"></ion-icon> Fabio</p>
              </div>
              <div class="grid-item"></div>


              <div class="grid-item">
                <img src="/images/messiCalvo.jpeg" alt="" />
                <p class="texto1">  <ion-icon class="texto1" name="logo-linkedin"></ion-icon> Gustavo</p>
              </div>
              <div class="grid-item"></div>
              <div class="grid-item"></div>
              <div class="grid-item"></div>
              <div class="grid-item">
                <img src="/images/messiCalvo.jpeg" alt="" />
                <p class="texto1"><ion-icon class="texto1" name="logo-linkedin"></ion-icon> Igor</p>
              </div>


              <div class="grid-item"> </div>
              <div class="grid-item">
                <img src="/images/messiCalvo.jpeg" alt="" />
                <p class="texto1"> <ion-icon class="texto1" name="logo-linkedin"></ion-icon> Lucas</p>
              </div>
              <div class="grid-item"> </div>
              <div class="grid-item">
                <img src="/images/messiCalvo.jpeg" alt="" />

                <p class="texto1">
                  <ion-icon class="texto1" name="logo-linkedin"></ion-icon> Leticia</p>
              </div>
              <div class="grid-item"></div>
            </div>
          </div>


        </section>

        <RedesSociais></RedesSociais>
      </main>
    </>
  )
}

export default QuemSomos;

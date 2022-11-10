import React, { Profiler } from "react";
import Header from "../Header";

import "./style.css";

function Usuario() {
  return (
    <>
      <Header />
      <div class="container-usuario">
        <div class="id-usuario">
          {/* <img src="../../../src/assets/image/imgMarvel.png" alt=""> */}
          <span>
            Olá <b>Nome</b>
          </span>
        </div>
        <div class="content-inf-usuario">
          <div class="nav-usuario">
            <nav>
              <ul>Dados pessoais</ul>
              <ul>Pedidos</ul>
              <ul>Endereços</ul>
            </nav>
          </div>
          <div class="content-dados-pessoais">
            <h1 class="titulo-padrao"></h1>
          </div>
        </div>
      </div>
    </>
  );
}

export default Usuario;

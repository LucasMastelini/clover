import React from "react";
import { useState } from "react";
import Footer from "../../components/Footer";
import Header from "../Header";
import EtapaAFazer from "./components/EtapaAFazer";
import EtapaFazendo from "./components/EtapaFazendo";
import EtapaFinalizada from "./components/EtapaFinalizada";
import CompraCartao from "./pages/CompraCartao";
import DadosPessoais from "../Usuario/pages/DadosPessoais";
import "./style.css";
import Enderecos from "./pages/Enderecos";

export default function FinalizarCompra() {
  const [step, setStep] = useState(2);

  return (
    <>
      <Header />
      <div className="container-pagina">
        <div className="barra-fixa bloquear-selecao">
          
          <div className="etapas">
            {step === 1 ? (
              <EtapaFazendo propsName={"Compra"} propsNumero={1}/>
            ) : step > 1 ? (
              <EtapaFinalizada>Compra</EtapaFinalizada>
            ) : (
              <EtapaAFazer propsName={"Compra"} propsNumero={1}/>
            )}

            <div className="etapa-andamento"></div>

            {step === 2 ? (
              <EtapaFazendo propsName={"Endereço"} propsNumero={2} />
            ) : step > 2 ? (
              <EtapaFinalizada>Endereço</EtapaFinalizada>
            ) : (
              <EtapaAFazer propsName={"Endereço"} propsNumero={2} />
            )}

            <div className="etapa-andamento"></div>

            {step === 3 ? (
              <EtapaFazendo propsName={"Dados"} propsNumero={3}/>
            ) : step > 3 ? (
              <EtapaFinalizada>Dados</EtapaFinalizada>
            ) : (
              <EtapaAFazer propsName={"Dados"} propsNumero={3}/>
            )}

            <div className="etapa-andamento"></div>

            {step === 4 ? (
              <EtapaFazendo propsName={"Pagamento"} propsNumero={4}/>
            ) : step > 4 ? (
              <EtapaFinalizada>Pagamento</EtapaFinalizada>
            ) : (
              <EtapaAFazer propsName={"Pagamento"} propsNumero={4}/>
            )}

            <div className="etapa-andamento"></div>

            {step === 5 ? (
              <EtapaFazendo propsName={"Confirmação"} propsNumero={2}/>
            ) : step > 5 ? (
              <EtapaFinalizada>Confirmação</EtapaFinalizada>
            ) : (
              <EtapaAFazer propsName={"Confirmação"} propsNumero={2}/>
            )}

          </div>
        </div>

        <div className="corpo-pagina">

          {/* {step === 2 ? <DadosPessoais /> : ""} */}
          {step === 2 ? <Enderecos setarPasso={setStep} passoAtual={step} /> : ""}
          {step === 3 ? <DadosPessoais /> : ""}
          {step === 4 ? <CompraCartao setarPasso={setStep} passoAtual={step} /> : ""}

        </div>
      </div>

      <Footer />
    </>
  );
}

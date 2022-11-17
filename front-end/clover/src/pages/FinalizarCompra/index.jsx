import React from 'react'
import Footer from '../../components/Footer'
import Header from '../Header'
import EtapaAFazer from './components/EtapaAFazer'
import EtapaFazendo from './components/EtapaFazendo'
import EtapaFinalizada from './components/EtapaFinalizada'
import CompraCartao from './pages/CompraCartao'
import "./style.css"

export default function FinalizarCompra({children}) {
  return (
    <>
        <Header/>
            <div className="container-pagina">
                <div className="barra-fixa bloquear-selecao">
                  <div className="etapas">

                    <EtapaFinalizada>Compra</EtapaFinalizada>
                    <div className="etapa-andamento"></div>

                    <EtapaFinalizada>Endereço</EtapaFinalizada>
                    <div className="etapa-andamento"></div>

                    <EtapaFinalizada>Dados</EtapaFinalizada>
                    <div className="etapa-andamento"></div>

                    <EtapaFazendo>Pagamento</EtapaFazendo>
                    <div className="etapa-andamento"></div>

                    <EtapaAFazer>Confirmação</EtapaAFazer>

                  </div>
                </div>
                <div className="corpo-pagina">
                    <CompraCartao/>
                </div>
            </div>
        <Footer/>
    </>
  )
}

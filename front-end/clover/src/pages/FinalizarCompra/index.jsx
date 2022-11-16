import React from 'react'
import Footer from '../../components/Footer'
import Header from '../Header'
import CompraCartao from './pages/CompraCartao'
import "./style.css"

export default function FinalizarCompra({children}) {
  return (
    <>
        <Header/>
            <div className="container-pagina">
                <div className="barra-fixa"></div>
                <div className="corpo-pagina">
                    <CompraCartao/>
                </div>
            </div>
        <Footer/>
    </>
  )
}

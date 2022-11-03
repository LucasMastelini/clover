
import ContainerCompra from "./components/ContainerCompra";
import ContainerDescricao from "./components/ContainerDescricao";
import CarrosselCards from "../../components/CarroselCards";
import CardProduto from "../../components/CardProduto";
import Header from "../Header";
import Footer from "../../components/Footer";

import './style.css';

function CompraProduto() {

    return (
        <>
        <Header/>
            <ContainerCompra />
            <ContainerDescricao />
            <h2 className="title-carrossel">O QUE OUTROS CLIENTES TAMBÉM COMPRARAM</h2>
            <CarrosselCards>
                <CardProduto />
                <CardProduto />
                <CardProduto />
                <CardProduto />
                <CardProduto />
                <CardProduto />
                <CardProduto />
            </CarrosselCards>
            <Footer/>
        </>

    );
}

export default CompraProduto;

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
            <h2 className="title-carrossel">TEXTO QUE VEM NO subtitulo DO JSON</h2>
            <div className="container-descricao-produto">
                <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Adipisci facere, quaerat officiis nemo reprehenderit amet facilis 
                    earum aliquam rerum, quae deserunt et cum quo blanditiis. 
                    Eum ullam fugit tempora? Cum?
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Adipisci facere, quaerat officiis nemo reprehenderit amet facilis 
                    earum aliquam rerum, quae deserunt et cum quo blanditiis. 
                    Eum ullam fugit tempora? Cum?
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                    Adipisci facere, quaerat officiis nemo reprehenderit amet facilis 
                    earum aliquam rerum, quae deserunt et cum quo blanditiis. 
                    Eum ullam fugit tempora? Cum?
                </p>
            </div>
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
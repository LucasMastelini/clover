import 'swiper/css'
import 'swiper/css/navigation'
import 'swiper/css/thumbs'
import './style.css'
import ContainerSlider from '../ContainerSlider'
import { productImages } from '../ContainerSlider/conteudo'
import { BsTruck } from 'react-icons/bs';


export default function ContainerCompra() {

    return (
        <>
            <section id="produto">
                <div className="slides">
                    <ContainerSlider images={productImages} />
                </div>
                <div id="informacoes">
                    <h1 id="titulo">Camiseta Gonew Dry Touch Fast Masculina - Branco</h1>
                    <div id="avaliacaoVendidos">
                        <div id="avaliacao">
                            <h3 id="avaliacaoTitulo">Avaliação</h3>
                            <div className="rating">
                                <input type="radio" name="star" id="star1" /><label htmlFor="star1">
                                </label>
                                <input type="radio" name="star" id="star2" /><label htmlFor="star2">
                                </label>
                                <input type="radio" name="star" id="star3" /><label htmlFor="star3">
                                </label>/
                                <input type="radio" name="star" id="star4" /><label htmlFor="star4">
                                </label>
                                <input type="radio" name="star" id="star5" /><label htmlFor="star5">
                                </label>
                            </div>
                        </div>
                        <h3 id="vendidos">Vendidos: +999999</h3>
                    </div>
                    <div className="calculoFrete">
                    <BsTruck />
                        <h4 className="tituloCalcularFrete">calcular o frete</h4>
                        <div id="calcular">
                            <input className="inputCalcular" placeholder="Insira o CEP" />
                            <button className="buttonCalcular">Calcular</button>
                        </div>
                    </div>
                    <div id="cores">
                        <h3>Selecione a cor</h3>
                        <div id="opcoesCores">
                            <div id="cor1">
                            </div>
                            <div id="cor2">
                            </div>
                            <div id="cor3">
                            </div>
                        </div>
                    </div>
                    <div id="tamanhos">
                        <h3>Selecione o tamanho</h3>
                        <div id="opcoesTamanhos">
                            <div id="tamanhoP">
                                P
                            </div>
                            <div id="tamanhoM">
                                M
                            </div>
                            <div id="tamanhoG">
                                G
                            </div>
                        </div>
                    </div>
                    <div id="preco">
                        <div id="precoVista">
                            <h1 id="precoVistaRiscado">R$6000</h1>
                            <h1 id="precoVistaSemRisco">R$9000</h1>
                        </div>
                        <h3 id="parcelas">ou 12x de R$8,10</h3>
                    </div>
                    <button id="comprar">Comprar</button>
                </div>
            </section>
        </>

    );
}

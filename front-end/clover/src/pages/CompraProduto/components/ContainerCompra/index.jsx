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
            <section className="produto">
                <div className="slides">
                    <ContainerSlider images={productImages} />
                </div>
                <div className="informacoes">
                    <h1 className="titulo">Camiseta Gonew Dry Touch Fast Masculina - Branco</h1>
                    <div className="avaliacao-vendidos">
                        <div className="avaliacao">
                            <h3 className="avaliacao-titulo">Avaliação</h3>
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
                        <h3 className="vendidos">Vendidos: +999999</h3>
                    </div>
                    <div className="calculo-frete">
                    <BsTruck />
                        <h4 className="titulo-calcular-frete">calcular o frete</h4>
                        <div className="calcular">
                            <input className="input-calcular" placeholder="Insira o CEP" />
                            <button className="button-calcular">Calcular</button>
                        </div>
                    </div>
                    <div className="cores">
                        <h3>Selecione a cor</h3>
                        <div className="opcoesCores">
                            <div className="cor1">
                            </div>
                            <div className="cor2">
                            </div>
                            <div className="cor3">
                            </div>
                        </div>
                    </div>
                    <div className="tamanhos">
                        <h3>Selecione o tamanho</h3>
                        <div className="opcoesTamanhos">
                            <div className="tamanhoP">
                                P
                            </div>
                            <div className="tamanhoM">
                                M
                            </div>
                            <div className="tamanhoG">
                                G
                            </div>
                        </div>
                    </div>
                    <div className="preco">
                        <div className="preco-vista">
                            <h1 className="preco-vista-riscado">R$6000</h1>
                            <h1 className="preco-vista-sem-risco">R$9000</h1>
                        </div>
                        <h3 className="parcelas">ou 12x de R$8,10</h3>
                    </div>
                    <button className="comprar">Comprar</button>
                </div>
            </section>
        </>

    );
}

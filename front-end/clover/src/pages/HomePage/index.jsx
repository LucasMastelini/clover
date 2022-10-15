import React from "react";
import Oferts from "./components/Oferts";
import Slider from "./components/Slider";
import './style.css';

function HomePage() {
    return(

        <>
            <Slider></Slider>

            <Oferts></Oferts>

            <h2 class="title-home">NOSSAS COLEÇÕES</h2>

            <div class="colletions-container">

                <div class="group-one-collections">
                    
                    <div class="item-collection-one">
                    <img class="img-collection" src="/images/imgMoletom.png" alt=""/>
                    <h2 class="text-collection-img">MOLETONS</h2>
                    </div>
                    <div class="item-collection-one">
                    <img class="img-collection" src="/images/imgCamiseta.png" alt=""/>
                    <h2 class="text-collection-img">CAMISETAS</h2>
                    </div>
                    
                </div>

                <div class="group-two-collections">

                    <div class="item-collection-two">
                    <img class="img-collection" src="/images/imgDecoracao.png" alt=""/>
                    <h2 class="text-collection-img">DECORAÇÃO</h2>
                    </div>
                    <div class="item-collection-two">
                    <img class="img-collection" src="/images/imgAcessorios.png" alt=""/>
                    <h2 class="text-collection-img">ACESSÓRIOS</h2>
                    </div>

                </div>

            </div>

            <h2 class="title-home">NOSSOS PARCEIROS</h2>

            <div class="collabs-container">
            
                <div class="items-collabs">
                    
                    <button class="item-collabs">
                    <img src="/images/imgDisney.png" alt=""/>
                    </button>
                    <button class="item-collabs">
                    <img src="/images/imgMarvel.png" alt=""/>
                    </button>
                    <button class="item-collabs">
                    <img src="/images/imgStranger.png" alt=""/>
                    </button>
                    <button class="item-collabs">
                    <img src="/images/imgDC.png" alt=""/>
                    </button>
                    <button class="item-collabs">
                    <img src="/images/imgStarWars.png" alt=""/>
                    </button>
                    <button class="item-collabs">
                    <img src="/images/imgDisney.png" alt=""/>
                    </button>
                    
                </div>

                <div class="arrow-slides-middle bloquear-selecao">
                    <div class="arrow-right" onclick="plusDivs(-1)">&#10094;</div>
                    <div class="arrow-left" onclick="plusDivs(1)">&#10095;</div>
                </div>

            </div>

            <h2 class="title-home">VEJA O QUE OS NOSSOS CLOVER LOVER FALAM DA NOSSA LOJA</h2>

            <div class="collabs-container">
            
                <div class="items-collabs">
                    
                    <button class="item-comments">
                    <span class="top-comments">
                        <img src="/images/icon-comentario.png" alt=""/>
                        <p>10/08/2022</p>
                    </span>
                    <span class="middle-comments">
                        <p class="text-comments">Gosto bastante da loja, compro na piticas a muito tempo, tenho várias camisetas e sempre lançam novidades que me atraem.</p>
                        <h4>Adelmo A.</h4>
                    </span>
                    <img src="/images/nota.png" alt=""/>
                    </button>
                    
                    <button class="item-comments">
                    <span class="top-comments">
                        <img src="/images/icon-comentario.png" alt=""/>
                        <p>10/08/2022</p>
                    </span>
                    <span class="middle-comments">
                        <p class="text-comments">Gosto bastante da loja, compro na piticas a muito tempo, tenho várias camisetas e sempre lançam novidades que me atraem.</p>
                        <h4>Adelmo A.</h4>
                    </span>
                    <img src="/images/nota.png" alt=""/>
                    </button>

                    <button class="item-comments">
                    <span class="top-comments">
                        <img src="/images/icon-comentario.png" alt=""/>
                        <p>10/08/2022</p>
                    </span>
                    <span class="middle-comments">
                        <p class="text-comments">Gosto bastante da loja, compro na piticas a muito tempo, tenho várias camisetas e sempre lançam novidades que me atraem.</p>
                        <h4>Adelmo A.</h4>
                    </span>
                    <img src="/images/nota.png" alt=""/>
                    </button>

                    <button class="item-comments">
                    <span class="top-comments">
                        <img src="/images/icon-comentario.png" alt=""/>
                        <p>10/08/2022</p>
                    </span>
                    <span class="middle-comments">
                        <p class="text-comments">Gosto bastante da loja, compro na piticas a muito tempo, tenho várias camisetas e sempre lançam novidades que me atraem.</p>
                        <h4>Adelmo A.</h4>
                    </span>
                    <img src="/images/nota.png" alt=""/>
                    </button>

                    <button class="item-comments">
                    <span class="top-comments">
                        <img src="/images/icon-comentario.png" alt=""/>
                        <p>10/08/2022</p>
                    </span>
                    <span class="middle-comments">
                        <p class="text-comments">Gosto bastante da loja, compro na piticas a muito tempo, tenho várias camisetas e sempre lançam novidades que me atraem.</p>
                        <h4>Adelmo A.</h4>
                    </span>
                    <img src="/images/nota.png" alt=""/>
                    </button>
                    
                </div>

                <div class="arrow-slides-middle bloquear-selecao">
                    <div class="arrow-right" onclick="plusDivs(-1)">&#10094;</div>
                    <div class="arrow-left" onclick="plusDivs(1)">&#10095;</div>
                </div>

            </div>

        </>

    );
}

export default HomePage;
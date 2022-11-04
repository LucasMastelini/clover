import React from "react";
import './style.css';
import camiseta from './images/camiseta.png'

export default function ContainerDescricao() {
    return (
        <>
            <section id="descricaoTamanhos">
                <img className="camiseta-exemplo" src={camiseta} />
                <div id="containerColunasTamanho">
                    <div className="colunas">
                        <h1>Tamanho</h1>
                        <p className="tamanhoRoupa">
                            <h3>P</h3>
                            Comprimento de base até a gola: 65cm. Largura da barriga: 50cm.
                            Comprimento do ombro: 14cm. Comprimento da manga: 19,5cm.
                        </p>
                        <p className="tamanhoRoupa">
                            <h3>M</h3>
                            Comprimento de base até a gola: 65cm. Largura da barriga: 50cm.
                            Comprimento do ombro: 14cm. Comprimento da manga: 19,5cm.
                        </p>
                        <p className="tamanhoRoupa">
                            <h3>G</h3>
                            Comprimento de base até a gola: 65cm. Largura da barriga: 50cm.
                            Comprimento do ombro: 14cm. Comprimento da manga: 19,5cm.
                        </p>
                    </div>
                    <div className="colunas">
                        <p className="tamanhoRoupa">
                            <h3>GG</h3>
                            Comprimento de base até a gola: 65cm. Largura da barriga: 50cm.
                            Comprimento do ombro: 14cm. Comprimento da manga: 19,5cm.
                        </p>
                        <p className="tamanhoRoupa">
                            <h3>XG</h3>
                            Comprimento de base até a gola: 65cm. Largura da barriga: 50cm.
                            Comprimento do ombro: 14cm. Comprimento da manga: 19,5cm.
                        </p>
                        <p className="tamanhoRoupa">
                            <h3>XGG</h3>
                            Comprimento de base até a gola: 65cm. Largura da barriga: 50cm.
                            Comprimento do ombro: 14cm. Comprimento da manga: 19,5cm.
                        </p>
                    </div>
                </div>
            </section>
        </>
    );
}
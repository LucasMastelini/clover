import React, { useEffect } from "react";
import './style.css';


export default function ContainerCompra() {

    useEffect(() => {
        var corAnterior;

        let images = [
            "https://imageup.me/images/83402098-f65f-43b7-b2c2-1cd6a93a5cb8.jpeg",
            "https://imageup.me/images/83402098-f65f-43b7-b2c2-1cd6a93a5cb8.jpeg",
            "https://imageup.me/images/83402098-f65f-43b7-b2c2-1cd6a93a5cb8.jpeg",
            "https://imageup.me/images/83402098-f65f-43b7-b2c2-1cd6a93a5cb8.jpeg",
        ]

        function mudarCores(event) {

            if (corAnterior) {
                corAnterior.className = "";
            }

            corAnterior = document.getElementById(event.target.id);
            corAnterior.className = "selected";

        }

        //////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////


        function imageSlider(parent, images) {

            let currentImage = 0;
            let slider = {
                parent: parent,
                images: parent.querySelector(".images"),
                thumbnails: parent.querySelector(".thumbnails"),
                backBtn: parent.querySelector(".back-btn"),
                nextBtn: parent.querySelector(".next-btn")
            };

            slider.images.innerHTML = images.map(function (image) {
                return `<img src="${image}"/>`
            }).join("");

            let imageNodes = slider.images.querySelectorAll("img");
            imageNodes[currentImage].classList.add("active");

            slider.thumbnails.innerHTML = slider.images.innerHTML;

            let thumbnailNodes = slider.thumbnails.querySelectorAll("img");
            thumbnailNodes[currentImage].classList.add("active");


            for (let i = 0; i < thumbnailNodes.length; i++) {
                thumbnailNodes[i].addEventListener("click", function () {
                    slider.thumbnails.querySelector("img.active").classList.remove("active");
                    thumbnailNodes[i].classList.add("active");
                    imageNodes[currentImage].classList.remove("active");
                    currentImage = i;
                    imageNodes[currentImage].classList.add("active");
                });
            }

            slider.backBtn.addEventListener("click", function () {
                imageNodes[currentImage].classList.remove("active");
                currentImage--;
                if (currentImage < 0) {
                    currentImage = images.length - 1;
                }
                imageNodes[currentImage].classList.add("active");
                slider.thumbnails.querySelector("img.active").classList.remove("active");
                thumbnailNodes[currentImage].classList.add("active");
            });

            slider.nextBtn.addEventListener("click", function () {
                imageNodes[currentImage].classList.remove("active");
                currentImage = (currentImage + 1) % images.length;
                imageNodes[currentImage].classList.add("active");
                slider.thumbnails.querySelector("img.active").classList.remove("active");
                thumbnailNodes[currentImage].classList.add("active");
            });

        }

        imageSlider(document.querySelector(".image-slider"), images);

        let cor1 = document.getElementById("cor1");
        let cor2 = document.getElementById("cor2");
        let cor3 = document.getElementById("cor3");


        cor1.addEventListener('click', function handleClick() {

            let contador = 0;

            var imagesSlider = document.querySelectorAll(".images img");
            var imagesThumbnail = document.querySelectorAll(".thumbnails img");

            images = [
                "../../assets/image/roupaslidebranca.png",
                "../../assets/image/roupaslidebranca.png",
                "../../assets/image/roupaslidebranca.png",
                "../../assets/image/roupaslidebranca.png",
                "../../assets/image/roupaslidebranca.png"
            ];

            for (let i = 0; i < imagesSlider.length; i++) {
                imagesSlider[i].src = images[contador];
                imagesThumbnail[i].src = images[contador];
                contador++;
            }
        });


        cor2.addEventListener('click', function handleClick() {

            let contador = 0;

            var imagesSlider = document.querySelectorAll(".images img");
            var imagesThumbnail = document.querySelectorAll(".thumbnails img");

            images = [
                "../../assets/image/roupaslidepreta.png",
                "../../assets/image/roupaslidepreta.png",
                "../../assets/image/roupaslidepreta.png",
                "../../assets/image/roupaslidepreta.png",
                "../../assets/image/roupaslidepreta.png",
            ];

            for (let i = 0; i < imagesSlider.length; i++) {
                imagesSlider[i].src = images[contador];
                imagesThumbnail[i].src = images[contador];
                contador++;
            }
        });



        cor3.addEventListener('click', function handleClick() {

            let contador = 0;

            var imagesSlider = document.querySelectorAll(".images img");
            var imagesThumbnail = document.querySelectorAll(".thumbnails img");

            images = [
                "../../assets/image/roupaslideazul.png",
                "../../assets/image/roupaslideazul.png",
                "../../assets/image/roupaslideazul.png",
                "../../assets/image/roupaslideazul.png",
                "../../assets/image/roupaslideazul.png",
            ];

            for (let i = 0; i < imagesSlider.length; i++) {
                imagesSlider[i].src = images[contador];
                imagesThumbnail[i].src = images[contador];
                contador++;
            }
        });



    }, []);

    return (
        <>
            <section id="produto">
                <div className="image-slider">
                    <div id="escopo">
                        <div className="images"></div>
                        <div className="back-btn">
                            <i className="fa-solid fa-caret-left"></i>
                        </div>
                        <div className="next-btn">
                            <i className="fa-solid fa-caret-right"></i>
                        </div>
                    </div>
                    <div className="thumbnails"></div>
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
                    <div id="calculoFrete">
                        <i className="fa-solid fa-truck"></i>
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


var corAnterior;

let images = [
    "../../assets/image/roupaslidebranca.png",
    "../../assets/image/roupaslidebranca.png",
    "../../assets/image/roupaslidebranca.png",
    "../../assets/image/roupaslidebranca.png",
    "../../assets/image/roupaslidebranca.png"
];

export function mudarCores(event) {

    if (corAnterior) {
        corAnterior.className = "";
    }

    corAnterior = document.getElementById(event.target.id);
    corAnterior.className = "selected";

}

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////


export function imageSlider(parent, images) {

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



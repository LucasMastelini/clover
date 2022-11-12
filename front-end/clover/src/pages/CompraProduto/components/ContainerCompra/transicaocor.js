var corAnterior;

var tamanhoAnterior;

export function mudarCores(event) {

    if (corAnterior) {
        corAnterior.className = "";
    }

    corAnterior = document.getElementById(event.target.id);
    corAnterior.className = "selected";
}


export function mudarTamanhos(event) {

    if (tamanhoAnterior) {
        tamanhoAnterior.className = "";
    }

    tamanhoAnterior = document.getElementById(event.target.id);
    tamanhoAnterior.className = "selected";
}
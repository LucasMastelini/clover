package clover.mlclover.resources.utils;

import clover.mlclover.domain.Endereco;

public class ListaObjOrdenada extends ListaObj{
    public ListaObjOrdenada(int maxLenght) {
        super(maxLenght);
        vetor = new Endereco[maxLenght];
    }
}

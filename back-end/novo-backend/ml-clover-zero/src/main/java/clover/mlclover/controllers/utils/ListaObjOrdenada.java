package clover.mlclover.controllers.utils;

import clover.mlclover.entities.Endereco;

public class ListaObjOrdenada extends ListaObj{
    public ListaObjOrdenada(int maxLenght) {
        super(maxLenght);
        vetor = new Endereco[maxLenght];
    }
}

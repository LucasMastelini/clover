package terceirosemestre.clover.resources.utils;

import terceirosemestre.clover.domain.Endereco;
import terceirosemestre.clover.dto.ClienteGerarArquivoDTO;

public class ListaObjOrdenada extends ListaObj{
    public ListaObjOrdenada(int maxLenght) {
        super(maxLenght);
        vetor = new Endereco[maxLenght];
    }
}

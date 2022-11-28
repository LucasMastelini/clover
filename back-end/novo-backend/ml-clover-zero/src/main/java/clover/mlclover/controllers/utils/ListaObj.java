package clover.mlclover.controllers.utils;


import clover.mlclover.entities.Endereco;

public class ListaObj{
    protected Endereco[] vetor;
    protected int nroElem;

    public ListaObj(int maxLenght) {
        vetor = new Endereco[maxLenght];
        nroElem = 0;
    }

    public void adiciona(Endereco e){

        if(vetor.length == nroElem){
            throw new IllegalStateException();
        } else{
            vetor[nroElem++] = e;
        }
    }

    public int busca(Endereco e){
        for(int i = 0; i < nroElem; i++){
            if(vetor[i] == e){
                return i;
            }
        }
        return -1;
    }
    public boolean removePeloIndice(int e){

        if(e > -1 && e < nroElem){
            for(int i = e + 1; i < nroElem; i++){
                vetor[i - 1] = vetor[i];
            }
            nroElem--;
            return true;
        }
        return false;
    }

    public boolean removeElemento(Endereco e){
        return removePeloIndice(busca(e));
    }

    public Endereco[] exibe(){
        return vetor;
    }

    public int getNroElem() {
        return nroElem;
    }

    public Endereco[] getVetor() {
        return vetor;
    }

    public boolean substitui(Endereco valorAntigo, Endereco valorNovo){
        for( int i = 0; i < nroElem; i++){
            if(vetor[i] == valorAntigo){
                vetor[i] = valorNovo;
                return true;
            }
        }
        System.out.println("Valor não encontrado");
        return false;
    }

    public int contaOcorrencias(Endereco valor){
        int contador = 0;
        for (Endereco v : vetor){
            if(v == valor){
                contador++;
            }
        }
        return contador;
    }

    public boolean adicionaNoInicio(Endereco valor){
        if(nroElem == vetor.length){
            System.out.println("Lista cheia");
            return false;
        }
        for(int i = nroElem; i >= 0; i--){
            vetor[i + 1] = vetor[i];
        }
        vetor[0] = valor;
        return true;
    }

    public void setVetor(Endereco[] vetor) {
        this.vetor = vetor;
    }

    public void setNroElem(int nroElem) {
        this.nroElem = nroElem;
    }
}

package clover.mlclover.services.exceptions;

public class CarrinhoVazioException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CarrinhoVazioException(String msg){
        super(msg);
    }

    public CarrinhoVazioException(String msg, Throwable cause){
        super(msg, cause);
    }
}

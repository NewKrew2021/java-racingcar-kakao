package exception;

public class NegativeNumberInputException extends RuntimeException {

    public NegativeNumberInputException(){
        super();
    }

    public NegativeNumberInputException(String msg){
        super(msg);
    }
}

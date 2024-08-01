package test.core.microuser.exception;

public class UserNoFoundException extends RuntimeException{

    public UserNoFoundException(String message){
        super(message);
    }
}

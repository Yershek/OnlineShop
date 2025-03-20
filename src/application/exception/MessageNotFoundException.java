package application.exception;

public class MessageNotFoundException extends ApplicationException{
    public MessageNotFoundException(String message) {
        super(message);
    }
}

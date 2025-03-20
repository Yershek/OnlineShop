package application.exception;

import application.command.commands.AddOrder;

public class UserFoundException extends ApplicationException {
    public UserFoundException(String message) {
        super(message);
    }
}

package application.command;

import javax.security.auth.login.LoginException;

public interface Command {
    void execute() throws LoginException;
}

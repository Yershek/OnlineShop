package application.command;

import application.exception.CommandNotFound;

import javax.security.auth.login.LoginException;
import java.util.Map;

public class CommandHandler {
    private Map<String, Command> commands;

    public CommandHandler(Map<String, Command> commands) {
        this.commands = commands;
    }

    public void cException(String userCommand) throws LoginException {
        if(commands.containsKey(userCommand)){
            Command command = commands.get(userCommand);
            command.execute();
        }else throw new CommandNotFound("Такой команды нет");
    }
}

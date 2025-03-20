package application.command.commands;

import application.command.Command;
import application.data.AuthContext;

public class Info implements Command {
    private AuthContext autificationContext;

    public Info(AuthContext autificationContext) {
        this.autificationContext = autificationContext;
    }

    @Override
    public void execute() {
        System.out.println("Авторищированный пользователи");
        if(autificationContext.autification()){
            System.out.println(autificationContext.getAuthUser().toString());
        }else {
            System.out.println("нет авторизированных пользователей");
        }
    }

    @Override
    public String toString() {
        return "Info - информация о авторизированных пользователей" ;
    }
}

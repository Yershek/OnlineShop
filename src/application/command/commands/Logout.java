package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.exception.NullAutException;

public class Logout implements Command {
    private AuthContext authContext;

    public Logout(AuthContext authContext) {
        this.authContext = authContext;
    }

    @Override
    public void execute() {
        if(!authContext.autification()) throw new NullAutException("Вы не авторизированны");
        authContext.logOut();
        System.out.println("Вы ди авторизировались");
    }

    @Override
    public String toString() {
        if(!authContext.autification()) return "";
        return "logout - выход с акаунта";
    }
}

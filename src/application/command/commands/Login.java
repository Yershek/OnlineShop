package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.UserServiceImpl;
import application.entity.Entity;
import application.exception.AutificationException;
import application.exception.LoginException;
import application.util.MyScanner;

public class Login implements Command {
    private AuthContext autificationContext;
    private UserServiceImpl userData;
    private MyScanner scanner = new MyScanner();

    public Login(AuthContext autificationContext, UserServiceImpl userData) {
        this.autificationContext = autificationContext;
        this.userData = userData;
    }

    @Override
    public void execute() {
        if(autificationContext.autification()){
            throw new LoginException("Вы авторизированны");
        }
        System.out.print("Введите логин: ");
        Entity user = userData.ByLogin(scanner.line());
        System.out.print("Введите пороль: ");
        if (!user.getPossword().equals(scanner.line())){
            throw new AutificationException("Неверный логин или пороль");
        }
        autificationContext.setAuthUser(user);
        System.out.println("Авторизация прошла успешно");
        if(!autificationContext.getAuthUser().getMessageinfo().equals(autificationContext.getAuthUser().getAllMessages().size())){
            System.out.println("У вас новое сообщение");
        }
    }

    @Override
    public String toString() {
        if(autificationContext.autification())return "";
        return "Login - авторизация пользователя";
    }
}

package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.UserServiceImpl;
import application.exception.LoginException;
import application.util.MyScanner;

public class UserById implements Command {
    private MyScanner scanner = new MyScanner();
    private AuthContext autification;
    private UserServiceImpl userData;

    public UserById(UserServiceImpl userData, AuthContext autification) {
       this.userData = userData;
       this.autification = autification;
    }

    @Override
    public void execute() {
        if(autification.autification() == false) throw new LoginException("Авторизируйтесь");
        System.out.print("Введите айди: ");
        System.out.println(userData.getId(scanner.sLong()));
    }

    @Override
    public String toString() {
        if(autification.autification() == true) return "";
        return "user_by_id - найди пользователя по айди";
    }
}

package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.UserServiceImpl;
import application.entity.Message;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class WriteAMessage implements Command {
    private UserServiceImpl userData;
    private AuthContext authContext;
    private MyScanner scanner = new MyScanner();

    public WriteAMessage(AuthContext authContext, UserServiceImpl userData) {
        this.authContext = authContext;
        this.userData = userData;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        System.out.print("Введите айди пользователя: ");
        Long id = scanner.sLong();
        System.out.print("Напишите сообщение: ");
        Message message = new Message();
        message.setMessage(scanner.line());
        message.setUser(authContext.getAuthUser());
        userData.getAll().stream().forEach(entity -> {if(entity.getId().equals(id)) entity.addMessages(message);});
    }

    @Override
    public String toString() {
        if(!authContext.autification()) return "";
        return "Write_A_Message - написать сообщение";
    }
}

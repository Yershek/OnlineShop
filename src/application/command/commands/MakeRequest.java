package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.UserServiceImpl;
import application.entity.Message;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class MakeRequest implements Command {
    private MyScanner scanner = new MyScanner();
    private AuthContext authContext;
    private UserServiceImpl userData;

    public MakeRequest(AuthContext authContext, UserServiceImpl userData) {
        this.authContext = authContext;
        this.userData = userData;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if (authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) throw new UserTypeException("Это команда вам не достуна");
        System.out.print("Введите айди постовщика: ");
        Long id = scanner.sLong();
        System.out.print("Напишите какие продукты вы хотите купить у этого постовщика: ");
        Message message = new Message();
        message.setMessage(scanner.line());
        message.setUser(authContext.getAuthUser());
        userData.getAll().stream().forEach(entity -> {if(entity.getId().equals(id)) entity.addMessages(message);});
    }

    @Override
    public String toString() {
        if(!authContext.autification()|| authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) return "";
        return "Make_Request - оформление заявки на продускт постовщику";
    }
}

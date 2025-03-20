package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.entity.Entity;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.MessageNotFoundException;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class ReadMessage implements Command {
    private AuthContext authContext;

    public ReadMessage(AuthContext authContext) {
        this.authContext = authContext;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(!authContext.getAuthUser().getMessageinfo().equals(authContext.getAuthUser().getAllMessages().size())){
            for (Long i = authContext.getAuthUser().getMessageinfo(); i < (authContext.getAuthUser().getMessageinfo() * 2); i++){
                System.out.println(authContext.getAuthUser().getMessagesId(i));
            }
            authContext.getAuthUser().setMessageinfo();
        }else {
            throw new MessageNotFoundException("У вас нет новых сообщений");
        }
    }

    @Override
    public String toString() {
        if(!authContext.autification()) return "";
        return "Read_Message - вывод всех новых сообщений";
    }
}

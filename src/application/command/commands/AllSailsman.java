package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.UserServiceImpl;
import application.entity.enums.UserType;
import application.entity.users.Provider;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class AllSailsman implements Command {
    private AuthContext authContext;
    private UserServiceImpl userData;

    public AllSailsman(AuthContext authContext, UserServiceImpl userData) {
        this.authContext = authContext;
        this.userData = userData;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        System.out.println("Вывод всех продовцов");
        for (int i = 0; i < userData.getAll().size(); i++) {
            if(userData.getAll().get(i).getUserType().equals(UserType.SAILSMAN)){
                System.out.println(userData.getAll().get(i));
            }
        }
    }

    @Override
    public String toString() {
        if(!authContext.autification() || authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman) return "";
        return "all_salesman - список продавцов";
    }
}

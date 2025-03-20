package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.UserServiceImpl;
import application.entity.enums.UserType;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class AllProvider implements Command {
    private UserServiceImpl userData;
    private AuthContext authContext;

    public AllProvider(AuthContext authContext, UserServiceImpl userData) {
        this.authContext = authContext;
        this.userData = userData;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Customer) throw new UserTypeException("Это команда вам не достуна");
        System.out.println("Вывод всех поставшиков");
        userData.getAll().forEach(userData -> {if(userData.getUserType().equals(UserType.PROVIDER)) System.out.println(userData);});
    }

    @Override
    public String toString() {
        if(!authContext.autification() || authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Customer) return "";
        return "All_Provider - вывод всех поставщиков";
    }
}

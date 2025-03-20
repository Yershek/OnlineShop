package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.CartServiceImpl;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class AllOrders implements Command {
    private AuthContext authContext;
    private CartServiceImpl cartHendler;

    public AllOrders(AuthContext authContext, CartServiceImpl cartHendler) {
        this.authContext = authContext;
        this.cartHendler = cartHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Customer) throw new UserTypeException("Это команда вам не достуна");
        cartHendler.getCart().stream().forEach(item -> {if(item.getUserGeneral().equals(authContext.getAuthUser()))
            System.out.println(item);});
    }

    @Override
    public String toString() {
        if(!authContext.autification()|| authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Customer) return "";
        return "All_Orders - вывод всех оформленых заказов";
    }
}

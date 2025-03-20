package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.CartServiceImpl;
import application.entity.users.Provider;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class Cart implements Command {
    private AuthContext authContext;
    private CartServiceImpl cartHendler;

    public Cart(AuthContext authContext, CartServiceImpl cartHendler) {
        this.authContext = authContext;
        this.cartHendler = cartHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        System.out.println("Вывод продуктов в корзине");
        cartHendler.getCart();
    }

    @Override
    public String toString() {
        if(!authContext.autification()||authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman)return "";
        return "Cart - просмотор корзины";
    }
}

package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.users.Provider;
import application.exception.NullAutException;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class Cotalogs implements Command {
    private AuthContext authContext;
    private ShopServiceImpl shopHendler;

    public Cotalogs(AuthContext authContext, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new NullAutException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider) throw new UserTypeException("Это команда вам не достуна");
        System.out.println(shopHendler.getAllcatologs());
    }

    @Override
    public String toString() {
        if(!authContext.autification()||authContext.getAuthUser() instanceof Provider) return "";
        return "Cotalogs - вывод списка типов товара";
    }
}

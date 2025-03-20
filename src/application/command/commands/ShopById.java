package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class ShopById implements Command {
    private MyScanner scanner = new MyScanner();
    private AuthContext authContext;
    private ShopServiceImpl shopHendler;

    public ShopById(AuthContext authContext, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Customer) throw new UserTypeException("Это команда вам не достуна");
        System.out.print("Введите айди магазина");
        System.out.println(shopHendler.getShopById(scanner.sLong()));
    }

    @Override
    public String toString() {
        if(!authContext.autification()|| authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) return "";
        return "Shop_By_Id - поиск магазина по айди";
    }
}

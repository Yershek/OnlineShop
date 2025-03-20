package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.Shop.Shop;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.NotShopException;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class InfoShop implements Command {
    private AuthContext authContext;
    private ShopServiceImpl shopHendler;

    public InfoShop(AuthContext authContext, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Customer) throw new UserTypeException("Это команда вам не достуна");
        for (Shop shop : shopHendler.getAllShops().keySet()){
            if(shop.getUserGeneral().equals(authContext.getAuthUser())){
                System.out.println(shop.toString());
            }
        }
        throw new NotShopException("У вас нет магазина");
    }

    @Override
    public String toString() {
        if(!authContext.autification()||authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Customer) return "";
        return "Info_Shop - вывод о магазине" ;
    }
}

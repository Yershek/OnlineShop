package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class AllShops implements Command {
    private AuthContext authContext;
    private ShopServiceImpl shopHendler;

    public AllShops(AuthContext authContext, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider) throw new UserTypeException("Это команда вам не достуна");
        if(authContext.getAuthUser() instanceof Customer) {
            System.out.println("Ввод всех магазинов");
            System.out.println(shopHendler.getAllShops().keySet());
        } else {
            System.out.println("Вывод всех своих магазинов");
            shopHendler.getAllShops().keySet().forEach(shop -> {if(shop.getUserGeneral().equals(authContext.getAuthUser()))
                System.out.println(shop);});
        }
    }

    @Override
    public String toString() {
        if(!authContext.autification()||authContext.getAuthUser() instanceof Provider)return "";
        return "all_shops - Список магазинов";
    }
}

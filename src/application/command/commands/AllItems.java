package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.users.Provider;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class AllItems implements Command {
    private AuthContext authContext;
    private ShopServiceImpl shopHendler;

    public AllItems(AuthContext authContext, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        System.out.println("Ввывод всех продуктов");
        System.out.println(shopHendler.getItemsShops());
    }

    @Override
    public String toString() {
        if(!authContext.autification() || authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman) return "";
        return "all_items - вывод всех товаров в системе";
    }
}

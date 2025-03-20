package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.Shop.Shop;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class AddShop implements Command {
    private MyScanner scanner = new MyScanner();
    private AuthContext authContext;
    private ShopServiceImpl shopHendler;

    public AddShop(AuthContext authContext, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) throw new UserTypeException("Это команда вам не достуна");
        Shop shop= new Shop();
        System.out.print("Введите название магазина: ");
        shop.setName(scanner.line());
        shop.setUserGeneral(authContext.getAuthUser());
        System.out.print("Введите адрес магазина: ");
        shop.setAdres(scanner.line());
        shopHendler.addShop(shop);
        System.out.println("Магазин создан");
    }

    @Override
    public String toString() {
        if(!authContext.autification() || authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) return "";
        return "Add_Shop - создать магазин или добавить филиал";
    }
}

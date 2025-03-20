package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.Shop.Item;
import application.entity.Shop.Shop;
import application.entity.users.Provider;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class LeaveReview implements Command {
    private MyScanner scanner = new MyScanner();
    private AuthContext authContext;
    private ShopServiceImpl shopHendler;

    public LeaveReview(AuthContext authContext, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        System.out.print("Введите айди магазина: ");
        Shop shop = shopHendler.getShopById(scanner.sLong());
        System.out.print("Введите айди товара: ");
        Long id = scanner.sLong();
        Item item = shopHendler.getItemById(id);
        System.out.println("Введите отзыв о товаре: ");
        item.setReview(scanner.line());
        shopHendler.ItemReal(shop,item,id);
    }

    @Override
    public String toString() {
        if(!authContext.autification()||authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman) return "";
        return "Leave_Review - оставить отзыв о товаре";
    }
}

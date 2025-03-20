package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.data.OrderData;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.Shop.Shop;
import application.entity.users.Customer;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class AddOrder implements Command {
    private MyScanner scanner = new MyScanner();
    private OrderData orderData;
    private AuthContext authContext;
    private ShopServiceImpl shopHendler;

    public AddOrder(AuthContext authContext, OrderData orderData, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.orderData = orderData;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if (authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        System.out.print("Введите айди магазина: ");
        Shop shop = shopHendler.getShopById(scanner.sLong());
        System.out.print("Введите айди сообшения: ");
        orderData.addShops(shop,authContext.getAuthUser(),authContext.getAuthUser().getMessagesId(scanner.sLong()));
        System.out.println("магазин добавлен в список");
    }

    @Override
    public String toString() {
        if(!authContext.autification() || authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Sailsman) return "";
        return "Add_Order - добавление магазина для поставки";
    }
}

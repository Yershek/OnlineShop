package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.Shop.Item;
import application.entity.Shop.Shop;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.NullPoinException;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class AddItem implements Command {
    private MyScanner scanner = new MyScanner();
    private AuthContext authContext;
    private ShopServiceImpl shopHendler;

    public AddItem(AuthContext authContext, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if (authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) throw new UserTypeException("Это команда вам не достуна");
        Item item = new Item();
        System.out.print("Введите айди магазина: ");
        Shop shop = shopHendler.getShopById(scanner.sLong());
        if(shop.getUserGeneral().equals(authContext.getAuthUser().getLogin())) throw new NullPoinException("Магазина с таким айди нету");
        System.out.print("Введите название продукта: ");
        item.setItemName(scanner.line());
        System.out.print("Введите цену продукта: ");
        item.setItemPrice(scanner.sLong());
        System.out.print("Введите количество продуста: ");
        item.setCall(scanner.sLong());
        System.out.print("Введите каталог: ");
        item.setUserGeneral(shop.getUserGeneral());
        shopHendler.addItem(shop,item,scanner.line().toLowerCase());
        System.out.println("Продукт добавлен");
    }

    @Override
    public String toString() {
        if(!authContext.autification() || authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) return "";
        return "Add_Item - добавление нового товара";
    }
}

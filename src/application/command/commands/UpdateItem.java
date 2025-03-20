package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ProviderItemServiceImpl;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.Entity;
import application.entity.Shop.Item;
import application.entity.Shop.Shop;
import application.entity.users.Customer;
import application.entity.users.Sailsman;
import application.exception.NotShopException;
import application.exception.NullAutException;
import application.exception.UserTypeException;
import application.util.MyScanner;

public class UpdateItem implements Command {
    private MyScanner scanner = new MyScanner();
    private ShopServiceImpl shopHendler;
    private AuthContext authContext;
    private ProviderItemServiceImpl providerItemHendler;

    public UpdateItem(AuthContext authContext, ProviderItemServiceImpl providerItemHendler, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.providerItemHendler = providerItemHendler;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() {
        if(!authContext.autification()) throw new NullAutException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Customer) throw new UserTypeException("Это команда вам не достуна");
        if(authContext.getAuthUser() instanceof Sailsman) {
            System.out.print("Введите айди магазина: ");
            Shop shop = shopHendler.getShopById(scanner.sLong());
            System.out.println("Введите айди продукта: ");
            updateItem(shop, scanner.sLong(), authContext.getAuthUser());
        } else {
            Item item = new Item();
            System.out.print("Введите айди продукта");
            Long id = scanner.sLong();
            System.out.print("Введите новое название продукта");
            String name = scanner.line();
            System.out.print("Введите новую цену продукта");
            Long price = scanner.sLong();
            System.out.print("Введите количесвто продукта");
            Long call = scanner.sLong();
            item.setItemName(name).setItemPrice(price).setCall(call);
            item.setUserGeneral(authContext.getAuthUser());
            providerItemHendler.readeItem(id,item);
            System.out.println("Продукт обновлен");
        }
    }

    public void updateItem(Shop shop,Long itemId, Entity authUser) throws NotShopException {
        if(!shop.getUserGeneral().equals(authUser)) throw new NotShopException("Такой магазин в вашем фелиале не найден!");
        System.out.print("Введите новое название продукта: ");
        String name = scanner.line();
        System.out.print("Введите новую цену продукта: ");
        shopHendler.updateItem(shop,itemId).setItemName(name).setItemPrice(scanner.sLong());
    }

    @Override
    public String toString() {
        if(!authContext.autification() || authContext.getAuthUser() instanceof Customer) return "";
        return "Update_Item - изменение данных продукта";
    }
}

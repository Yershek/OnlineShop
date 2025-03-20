package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ProviderItemServiceImpl;
import application.entity.Shop.Item;
import application.entity.users.Customer;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;
import application.util.MyScanner;
import javax.security.auth.login.LoginException;

public class AddProduct implements Command {
    private MyScanner scanner = new MyScanner();
    private AuthContext authContext;
    private ProviderItemServiceImpl providerItemHendler;

    public AddProduct(AuthContext authContext, ProviderItemServiceImpl providerItemHendler) {
        this.authContext = authContext;
        this.providerItemHendler = providerItemHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if (authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        Item item = new Item();
        System.out.print("Введите название продукта: ");
        item.setItemName(scanner.line());
        System.out.print("Введите цену продуста: ");
        item.setItemPrice(scanner.sLong());
        System.out.print("Введите количество продуста: ");
        item.setCall(scanner.sLong());
        item.setUserGeneral(authContext.getAuthUser());
        providerItemHendler.adddItem(item);
        System.out.print("Продукт добавлен");
    }

    @Override
    public String toString() {
        if(!authContext.autification() || authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Sailsman) return "";
        return "Add_Product - добовление товара";
    }
}

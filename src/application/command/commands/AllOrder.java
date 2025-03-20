package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.data.OrderData;
import application.entity.users.Customer;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class AllOrder implements Command {
    private AuthContext authContext;
    private OrderData orderData;

    public AllOrder(AuthContext authContext, OrderData orderData) {
        this.authContext = authContext;
        this.orderData = orderData;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if (authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        System.out.println("Вывод всех магазинов к которым оформлена доставка");
        orderData.getAllShops().get(authContext.getAuthUser()).keySet().stream().forEach(shop -> System.out.println("NameShop: "+shop.getName() + " adres:" + shop.getAdres()));
    }

    @Override
    public String toString() {
        return "All_Order - вывод списка магазинов к которым оформлена поставка";
    }
}

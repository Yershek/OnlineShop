package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.entity.Message;
import application.entity.Shop.Item;
import application.service.serviceImpl.CartServiceImpl;
import application.entity.users.Provider;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class Checkout implements Command {
    private MyScanner scanner = new MyScanner();
    private AuthContext authContext;
    private CartServiceImpl cartHendler;

    public Checkout(AuthContext authContext, CartServiceImpl cartHendler) {
        this.authContext = authContext;
        this.cartHendler = cartHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        System.out.print("Введите адрес: ");
        scanner.line();
        System.out.print("Введите айди продукта: ");
        Long id = scanner.sLong();
        Message message = new Message();
        message.setUser(authContext.getAuthUser());
        message.setMessage("Увас купили товар" + cartHendler.getCart().get(Math.toIntExact(id)));
        cartHendler.getCart().stream().forEach(item -> {if(item.getId().equals(id)) item.getUserGeneral().addMessages(message);});
        cartHendler.removeItemById(id);
        System.out.println("Заказ оформлен ждите 7 дней");
    }

    @Override
    public String toString() {
        if(!authContext.autification()||authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman)return "";
        return "Checkout - оформление заказа";
    }
}

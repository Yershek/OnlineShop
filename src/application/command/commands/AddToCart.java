package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.CartServiceImpl;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.users.Provider;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class AddToCart implements Command {
    private MyScanner scanner= new MyScanner();
    private AuthContext authContext;
    private CartServiceImpl cartHendler;
    private ShopServiceImpl shopHendler;

    public AddToCart(AuthContext authContext, CartServiceImpl cartHendler) {
        this.authContext = authContext;
        this.cartHendler = cartHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        System.out.print("Введите айди продукта");
        cartHendler.addCart(shopHendler.getItemById(scanner.sLong()));
        System.out.println("Продукт добавлен в корзину ");
    }

    @Override
    public String toString() {
        if(!authContext.autification()||authContext.getAuthUser() instanceof Provider || authContext.getAuthUser() instanceof Sailsman) return "";
        return "Add_To_Cart - добавить товар в корзину";
    }
}

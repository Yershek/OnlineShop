package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.NullAutException;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class AddCatologs implements Command {
    private MyScanner scanner = new MyScanner();
    private ShopServiceImpl shopHendler;
    private AuthContext authContext;

    public AddCatologs(AuthContext authContext, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new NullAutException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) throw new UserTypeException("Это команда вам не достуна");
        System.out.print("Введите католог товара: ");
        shopHendler.addCotalogs(scanner.line());
    }

    @Override
    public String toString() {
        return "Add_Cotalogs - добавление католога товаров";
    }
}

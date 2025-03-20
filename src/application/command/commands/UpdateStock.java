package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ProviderItemServiceImpl;
import application.entity.users.Customer;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class UpdateStock implements Command {
    private MyScanner scanner = new MyScanner();
    private AuthContext authContext;
    private ProviderItemServiceImpl providerItemHendler;

    public UpdateStock(AuthContext authContext, ProviderItemServiceImpl providerItemHendler) {
        this.authContext = authContext;
        this.providerItemHendler = providerItemHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        System.out.print("Введите сначала айди потом количесво");
        providerItemHendler.updateStock(scanner.sLong(),scanner.sLong());
        System.out.println("Количество товара обнавленно");
    }

    @Override
    public String toString() {
        if(!authContext.autification()|| authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Sailsman) return "";
        return "Update_Stock - изменить количесво товара";
    }
}

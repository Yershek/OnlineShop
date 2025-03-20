package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ProviderItemServiceImpl;
import application.entity.users.Customer;
import application.entity.users.Sailsman;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class InfoItem implements Command {
    private ProviderItemServiceImpl providerItemHendler;
    private AuthContext authContext;

    public InfoItem(AuthContext authContext, ProviderItemServiceImpl providerItemHendler) {
        this.authContext = authContext;
        this.providerItemHendler = providerItemHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if(authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Sailsman) throw new UserTypeException("Это команда вам не достуна");
        System.out.println("Вывод списка своих товаров");
        providerItemHendler.getProviderItem().stream().forEach(item -> {if(item.getUserGeneral().equals(authContext.getAuthUser()))
            System.out.println(item);});
    }

    @Override
    public String toString() {
        if(!authContext.autification()|| authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Sailsman) return "";
        return "Info_Item - вывод списка своих товаров";
    }
}

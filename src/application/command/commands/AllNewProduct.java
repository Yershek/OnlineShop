package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ProviderItemServiceImpl;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.ProviderItemNewNotFoundException;
import application.exception.UserTypeException;

import javax.security.auth.login.LoginException;

public class AllNewProduct implements Command {
    private AuthContext authContext;
    private ProviderItemServiceImpl providerItemHendler;

    public AllNewProduct(AuthContext authContext, ProviderItemServiceImpl providerItemHendler) {
        this.authContext = authContext;
        this.providerItemHendler = providerItemHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if (authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) throw new UserTypeException("Это команда вам не достуна");
        if(!providerItemHendler.getProviderinfoItem().equals(providerItemHendler.getProviderItem().size())){
            for (Long i = providerItemHendler.getProviderinfoItem(); i < (providerItemHendler.getProviderinfoItem()+providerItemHendler.getProviderinfoItem()); i++) {
                System.out.println(providerItemHendler.getProviderItem().get(Math.toIntExact(i)));
            }
            providerItemHendler.setProviderinfoItem();
        }else {
            throw new ProviderItemNewNotFoundException("У постовщиков нет нового товара");
        }
    }

    @Override
    public String toString() {
        return "All_New_Product - вывод новых товаров у постовшика";
    }
}

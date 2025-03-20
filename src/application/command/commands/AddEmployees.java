package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.ShopServiceImpl;
import application.entity.Shop.Employees;
import application.entity.Shop.Shop;
import application.entity.users.Customer;
import application.entity.users.Provider;
import application.exception.NullPoinException;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class AddEmployees implements Command {
    private MyScanner scanner = new MyScanner();
    private ShopServiceImpl shopHendler;
    private AuthContext authContext;

    public AddEmployees(AuthContext authContext, ShopServiceImpl shopHendler) {
        this.authContext = authContext;
        this.shopHendler = shopHendler;
    }

    @Override
    public void execute() throws LoginException{
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if (authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) throw new UserTypeException("Это команда вам не достуна");
        Employees employees = new Employees();
        System.out.print("Введите айди магазина: ");
        Shop shop = shopHendler.getShopById(scanner.sLong());
        if(!shop.getUserGeneral().equals(authContext.getAuthUser().getLogin())) throw new NullPoinException("Магазина с таким айди нету");
        System.out.print("Ведите имя рабочего: ");
        employees.setName(scanner.line());
        System.out.print("Введите фамилию рабочего: ");
        employees.setSurname(scanner.line());
        System.out.print("Введите адрес рабочего");
        employees.setAdres(scanner.line());
        shop.setEmployees(employees);
        System.out.println("Рабочий добавлен");
        System.out.print("Хотите ещё добавить? Введите 'да' если хотите");
        if(scanner.line().toLowerCase().equals("да")) execute();
    }

    @Override
    public String toString() {
        if(!authContext.autification() || authContext.getAuthUser() instanceof Customer || authContext.getAuthUser() instanceof Provider) return "";
        return "Add_Employees - добавление сотрудника";
    }
}

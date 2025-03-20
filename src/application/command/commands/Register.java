package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.UserServiceImpl;
import application.entity.Entity;
import application.entity.enums.UserType;
import application.exception.ApplicationException;
import application.exception.LoginException;
import application.exception.RegisterException;
import application.exception.UserNotFoundException;
import application.util.MyScanner;

public class Register implements Command {
    private MyScanner scanner = new MyScanner();
    private UserServiceImpl userData;
    private AuthContext autification;

    public Register(UserServiceImpl userData, AuthContext autification) {
        this.autification = autification;
        this.userData = userData;
    }

    @Override
    public void execute() {
        if(autification.autification() == true) throw new LoginException("Вы авторизированны");
        System.out.print("Введите логин: ");
        String login = scanner.line();
        System.out.print("Ввелите пороль: ");
        String password = scanner.line();
        Entity user = getUserTypes();
        user.setLogin(login);
        user.setPossword(password);
        try{
            userData.ByLogin(login);
        }catch (UserNotFoundException exception){
            userData.addUser(user);
            System.out.println("Регистрация прошла успешно");
        }catch (ApplicationException exception){
            throw exception;
        }
    }

    public Entity getUserTypes(){
        System.out.println("Выбирите тип пользователя");
        UserType[] userTypes = UserType.values();
        for (int i = 0; i < userTypes.length; i++) {
            System.out.println(i+1+") " + userTypes[i].getDescription());
        }
        String type = scanner.line().toLowerCase();
        for (int i = 0; i < userTypes.length; i++) {
            if(type.equals(i + 1 + "")){
                return userTypes[i].getNewUser().crateNewUsers();
            }
        }
        for (int i = 0; i < userTypes.length; i++) {
            if(userTypes[i].name().equalsIgnoreCase(type) || userTypes[i].getDescription().equalsIgnoreCase(type)){
                return userTypes[i].getNewUser().crateNewUsers();
            }
        }
        throw new RegisterException("не верно выбран тип пользователя ");
    }
    @Override
    public String toString() {
        if(autification.autification() == true) return "";
        return "register - регистрация пользователя";
    }
}

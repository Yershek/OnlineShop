package application.command.commands;

import application.command.Command;
import application.service.serviceImpl.UserServiceImpl;
import application.entity.Entity;

public class InfoAll implements Command {
    private UserServiceImpl userData;

    public InfoAll(UserServiceImpl userData) {
        this.userData = userData;
    }

    @Override
    public void execute() {
        System.out.println("Пользователи системы");
        for (Entity element : userData.getAll()){
            System.out.println(element.toString());
        }
    }

    @Override
    public String toString() {
        return "info_all - информация о пользователях";
    }
}

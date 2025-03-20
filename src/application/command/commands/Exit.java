package application.command.commands;

import application.command.Command;
import application.util.MyScanner;

import java.util.Scanner;

public class Exit implements Command {

    @Override
    public void execute() {
        System.out.println("Программа зовершены");
        System.exit(1);
    }

    @Override
    public String toString() {
        return "Exit - завершение комманды";
    }
}

package application.command.commands;

import application.command.Command;

import java.util.Collection;

public class Help implements Command{
    private Collection<Command> commands;

    public Help(Collection<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("Вывод списка комманд");
        commands.forEach(command -> {if(!command.toString().equals("")) System.out.println(command);});
    }

    @Override
    public String toString() {
        return "help - вывод списка комманд";
    }

}

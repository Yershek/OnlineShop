package application;

import application.command.CommandHandler;
import application.exception.ApplicationException;
import application.exception.CommandNotFound;
import application.util.MyScanner;

public class Application {
    private MyScanner scanner = new MyScanner();
    private CommandHandler commandHandler;

    public Application(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void run(){
        System.out.println("Программа началась");
        while (true)
        {
            System.out.print("Введите комманду: ");
            String userCommand = scanner.line().toLowerCase();
            try {
                commandHandler.cException(userCommand);
            }catch (CommandNotFound exception){
                exception.printStackTrace();
            }catch (ApplicationException exception){
                System.out.println("Команда прервона");
                exception.printStackTrace();
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}

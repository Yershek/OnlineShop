package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.PostServiceImpl;
import application.exception.NullAutException;
import application.util.MyScanner;

public class PosyById implements Command {
    private MyScanner scanner = new MyScanner();
    private PostServiceImpl postHendler;
    private AuthContext authContext;

    public PosyById(PostServiceImpl postHendler, AuthContext authContext) {
        this.postHendler = postHendler;
        this.authContext = authContext;
    }

    @Override
    public void execute() {
        if(!authContext.autification()) throw new NullAutException("Вы не авторизированны");
        System.out.print("Введите айди поста: ");
        System.out.println(postHendler.getPostById(scanner.sLong()));
    }

    @Override
    public String toString() {
        if(!authContext.autification()) return "";
        return "Posy_By_Id - найти пост по его айди";
    }
}

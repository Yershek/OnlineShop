package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.PostServiceImpl;
import application.exception.NullAutException;
import application.util.MyScanner;

public class PostByLogin implements Command {
    private MyScanner scanner = new MyScanner();
    private PostServiceImpl postHendler;
    private AuthContext authContext;

    public PostByLogin(PostServiceImpl postHendler, AuthContext authContext) {
        this.authContext = authContext;
        this.postHendler = postHendler;
    }

    @Override
    public void execute() {
        if(!authContext.autification()) throw new NullAutException("Вы не авторизированны");
        System.out.print("Введите логин пользователя поста: ");
        System.out.println(postHendler.getPostsByLogin(scanner.line()));
    }

    @Override
    public String toString() {
        if(!authContext.autification()) return "";
        return "Post_By_Login - найти пост по логину пользователя";
    }
}

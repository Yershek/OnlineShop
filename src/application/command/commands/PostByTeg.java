package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.PostServiceImpl;
import application.exception.NullAutException;
import application.util.MyScanner;

public class PostByTeg implements Command {
    private MyScanner scanner = new MyScanner();
    private PostServiceImpl postHendler;
    private AuthContext authContext;

    public PostByTeg(PostServiceImpl postHendler, AuthContext authContext) {
        this.postHendler = postHendler;
        this.authContext = authContext;
    }

    @Override
    public void execute() {
        if(!authContext.autification()) throw new NullAutException("Вы не авторизированны");
        System.out.print("Введите заголовок поста: ");
        System.out.println(postHendler.getPostByTeg(scanner.line()));
    }

    @Override
    public String toString() {
        if(!authContext.autification()) return "";
        return "Post_By_Teg - найти пост по заголовку";
    }
}


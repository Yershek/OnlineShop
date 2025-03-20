package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.PostServiceImpl;

import javax.security.auth.login.LoginException;

public class AllPosts implements Command {
    private PostServiceImpl postHendler;
    private AuthContext authContext;

    public AllPosts(PostServiceImpl postHendler, AuthContext authContext) {
        this.postHendler = postHendler;
        this.authContext = authContext;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        System.out.println("Ввод всех постов");
        System.out.println(postHendler.getPosts());

    }
    @Override
    public String toString() {
        if(!authContext.autification()) return "";
        return "All_Posts - вывод всех постов";
    }
}

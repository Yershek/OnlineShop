package application.command.commands;

import application.command.Command;
import application.data.AuthContext;
import application.service.serviceImpl.PostServiceImpl;
import application.entity.Posts;
import application.entity.users.Customer;
import application.exception.UserTypeException;
import application.util.MyScanner;

import javax.security.auth.login.LoginException;

public class AddPost implements Command {
    private MyScanner scanner = new MyScanner();
    private PostServiceImpl postHendler;
    private AuthContext authContext;

    public AddPost(AuthContext authContext, PostServiceImpl postHendler) {
        this.authContext = authContext;
        this.postHendler = postHendler;
    }

    @Override
    public void execute() throws LoginException {
        if(!authContext.autification()) throw new LoginException("Вы не авторизированны");
        if (authContext.getAuthUser() instanceof Customer) throw new UserTypeException("Это команда вам не достуна");
        Posts post = new Posts();
        System.out.println("Введите заголовок");
        post.setTeg(scanner.line());
        System.out.println("Введите контент: ");
        post.setContent(scanner.line());
        post.setPostsType(authContext.getAuthUser());

        postHendler.addPosts(post);
    }

    @Override
    public String toString() {
        if(!authContext.autification() || authContext.getAuthUser() instanceof Customer) return "";
        return "Add_Post - добавить пост";
    }
}

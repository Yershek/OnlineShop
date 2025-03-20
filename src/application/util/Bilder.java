package application.util;

import application.Application;
import application.command.Command;
import application.command.CommandHandler;
import application.command.commands.*;
import application.data.*;
import application.service.serviceImpl.*;

import java.util.HashMap;
import java.util.Map;

public class Bilder {
    private CommandHandler commandHandler;
    private Map<String, Command> commands;
    private UserServiceImpl userData;
    private AuthContext autificationContext;
    private PostServiceImpl postHendler;
    private ShopServiceImpl shopHendler;
    private ProviderItemServiceImpl providerItemHendler;
    private CartServiceImpl cartHendler;
    private OrderData orderData;

    public Bilder() {
        setAuthContext();
        setOrderData();
        setUserData();
        setProvdrItem();
        setShopHendler();
        setPostHendler();
        setCartHendler();
        setCommands();
        setCommandHandler();
    }

    public void setOrderData() {
        this.orderData = new OrderData();
    }

    public Bilder setCartHendler(){
        this.cartHendler = new CartServiceImpl();
        return this;
    }

    public Bilder setProvdrItem(){
        this.providerItemHendler = new ProviderItemServiceImpl();
        return this;
    }

    public Bilder setShopHendler(){
        this.shopHendler = new ShopServiceImpl();
        return this;
    }

    public Bilder setCommandHandler() {
        this.commandHandler = new CommandHandler(commands);
        return this;
    }

    public Bilder setUserData() {
        this.userData = new UserServiceImpl();
        return this;
    }

    public Bilder setPostHendler(){
        this.postHendler = new PostServiceImpl();
        return this;
    }

    public Bilder setAuthContext(){
        this.autificationContext = new AuthContext();
        return this;
    }

    public Bilder setCommands() {
        this.commands = new HashMap<>();
        this.commands.put("exit", new Exit());
        this.commands.put("help", new Help(commands.values()));
        this.commands.put("register", new Register(userData, autificationContext));
        this.commands.put("info_all", new InfoAll(userData));
        this.commands.put("login", new Login(autificationContext, userData));
        this.commands.put("info", new Info(autificationContext));
        this.commands.put("logout", new Logout(autificationContext));
        this.commands.put("user_by_id", new UserById(userData, autificationContext));
        this.commands.put("add_post", new AddPost(autificationContext, postHendler));
        this.commands.put("post_by_id", new PosyById(postHendler, autificationContext));
        this.commands.put("post_by_login", new PostByLogin(postHendler, autificationContext));
        this.commands.put("post_by_teg", new PostByTeg(postHendler, autificationContext));
        this.commands.put("all_post", new AllPosts(postHendler, autificationContext));
        this.commands.put("add_shop", new AddShop(autificationContext,shopHendler));
        this.commands.put("add_employees", new AddEmployees(autificationContext, shopHendler));
        this.commands.put("add_item", new AddItem(autificationContext, shopHendler));
        this.commands.put("update_item", new UpdateItem(autificationContext,providerItemHendler, shopHendler));
        this.commands.put("add_product", new AddProduct(autificationContext, providerItemHendler));
        this.commands.put("all_items", new AllItems(autificationContext,shopHendler));
        this.commands.put("all_shops", new AllShops(autificationContext,shopHendler));
        this.commands.put("all_salesman", new AllSailsman(autificationContext,userData));
        this.commands.put("update_stock", new UpdateStock(autificationContext,providerItemHendler));
        this.commands.put("add_to_cart", new AddToCart(autificationContext,cartHendler));
        this.commands.put("cart", new Cart(autificationContext,cartHendler));
        this.commands.put("checkout", new Checkout(autificationContext,cartHendler));
        this.commands.put("leave_review", new LeaveReview(autificationContext, shopHendler));
        this.commands.put("all_provider", new AllProvider(autificationContext,userData));
        this.commands.put("shop_by_id", new ShopById(autificationContext,shopHendler));
        this.commands.put("info_item", new InfoItem(autificationContext,providerItemHendler));
        this.commands.put("add_cotalogs", new AddCatologs(autificationContext,shopHendler));
        this.commands.put("cotalogs", new Cotalogs(autificationContext,shopHendler));
        this.commands.put("info_shop", new InfoShop(autificationContext,shopHendler));
        this.commands.put("all_orders", new AllOrders(autificationContext,cartHendler));
        this.commands.put("add_order", new AddOrder(autificationContext,orderData,shopHendler));
        this.commands.put("all_order", new AllOrder(autificationContext,orderData));
        this.commands.put("all_new_product", new AllNewProduct(autificationContext,providerItemHendler));
        this.commands.put("make_request", new MakeRequest(autificationContext,userData));
        this.commands.put("read_message", new ReadMessage(autificationContext));
        this.commands.put("write_a_message", new WriteAMessage(autificationContext,userData));
        return this;
    }

    public Application bild(){
        return new Application(commandHandler);
    }
}

package application.data;

import application.entity.Shop.Item;

import java.util.ArrayList;
import java.util.List;

public class CartData {
    protected List<Item> cart;
    protected Long id;

    public CartData() {
        this.cart = new ArrayList<>();
        this.id = 0L;
    }

    public List<Item> getCart() {
        return cart;
    }

    public void addCart(Item item){
        item.setId(id++);
        cart.add(item);
    }
}

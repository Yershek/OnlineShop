package application.service;

import application.entity.Shop.Item;

import java.util.List;

public interface CartSevice {
    public void removeItemById(Long id);
    public void addCart(Item item);
    public List<Item> getCart();
}

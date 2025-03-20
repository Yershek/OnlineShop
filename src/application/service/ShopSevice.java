package application.service;

import application.entity.Shop.Item;
import application.entity.Shop.Shop;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ShopSevice {
    public void addCotalogs(String catol);
    public Collection<List<Item>> getItemsShops();
    public Set<String> getAllcatologs();
    public Item getItemById(Long id);
    public void ItemReal(Shop shop, Item item, Long id);
    public Shop getShopById(Long id);
    public Item updateItem(Shop shop, Long id);
    public void addItem(Shop shop, Item item,String catol);
    public Map<Shop, Map<String, List<Item>>> getAllShops();
    public void addShop(Shop shop);
}

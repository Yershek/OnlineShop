package application.data;

import application.entity.Shop.Item;
import application.entity.Shop.Shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopData {
    protected Map<Shop, Map<String, List<Item>>> shops;
    protected Long id;
    protected Long itemId;

    public ShopData() {
        id = 0L;
        itemId = 0L;
        this.shops = new HashMap<>();
    }

    public void addItem(Shop shop, Item item,String catol){
        item.setId(itemId++);
        shops.get(shop).get(catol).add(item);
    }

    public Map<Shop, Map<String, List<Item>>> getAllShops() {
        return shops;
    }

    public void addShop(Shop shop){
        shop.setId(id++);
        shops.put(shop, new HashMap<>());
    }
}

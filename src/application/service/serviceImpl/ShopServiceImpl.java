package application.service.serviceImpl;

import application.data.ShopData;
import application.entity.Shop.Item;
import application.entity.Shop.Shop;
import application.exception.ItemsNotFoundException;
import application.exception.NotShopException;
import application.service.ShopSevice;

import java.util.*;

public class ShopServiceImpl implements ShopSevice {
    ShopData shopData;

    @Override
    public void addCotalogs(String catol){
        for (Shop shop1 : shopData.getAllShops().keySet()){
            if(!shopData.getAllShops().get(shop1).keySet().equals(catol)){
                shopData.getAllShops().get(shop1).put(catol, new ArrayList<>());
            }
        }
    }

    @Override
    public Collection<List<Item>> getItemsShops(){
        Map<String, List<Item>> asdw = (Map<String, List<Item>>) shopData.getAllShops().values();
        return asdw.values();
    }

    @Override
    public Set<String> getAllcatologs(){
        Map<String, List<Item>> asdw = (Map<String, List<Item>>) shopData.getAllShops().values();
        return asdw.keySet();
    }

    @Override
    public Item getItemById(Long id){
        List<Item> items = new ArrayList<>();
        for (Map.Entry<Shop, Map<String, List<Item>>> entry : shopData.getAllShops().entrySet()) {
            items.add((Item) entry.getValue());
        }
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getId().equals(id)){
                return items.get(i);
            }
        }
        throw new ItemsNotFoundException("С таким айди продускта нет");
    }

    @Override
    public void ItemReal(Shop shop, Item item, Long id){
        for(String string : shopData.getAllShops().get(shop).keySet()){
            if(shopData.getAllShops().get(shop).get(string).equals(item)){
                shopData.getAllShops().get(shop).get(string).set(Math.toIntExact(id),item);
            }
        }
    }

    @Override
    public Shop getShopById(Long id){
        for(Shop shop : shopData.getAllShops().keySet()){
            if(shop.getId().equals(id)){
                return shop;
            }
        }
        throw new NotShopException("Магазин с таким логином не найден");
    }

    @Override
    public Item updateItem(Shop shop, Long id){
        for(String string : shopData.getAllShops().get(shop).keySet()){
            return shopData.getAllShops().get(shop).get(string).stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
        }
        throw new ItemsNotFoundException("с таким айди продуста нет");
    }

    @Override
    public void addItem(Shop shop, Item item, String catol) {
        shopData.addItem(shop,item,catol);
    }

    @Override
    public Map<Shop, Map<String, List<Item>>> getAllShops() {
        return shopData.getAllShops();
    }

    @Override
    public void addShop(Shop shop) {
        shopData.addShop(shop);
    }
}

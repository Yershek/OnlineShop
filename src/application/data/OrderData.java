package application.data;

import application.entity.Entity;
import application.entity.Message;
import application.entity.Shop.Shop;

import java.util.HashMap;
import java.util.Map;

public class OrderData {
    private Map<Entity,Map<Shop, Message>> shops;

    public OrderData() {
        this.shops = new HashMap<>();
    }

    public Map<Entity, Map<Shop, Message>> getAllShops() {
        return shops;
    }

    public void addShops(Shop shops, Entity entity, Message message) {
        this.shops.get(entity).put(shops,message);
    }

}

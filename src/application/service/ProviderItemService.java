package application.service;

import application.entity.Shop.Item;

import java.util.List;

public interface ProviderItemService {
    public Long getProviderinfoItem();
    public void setProviderinfoItem();
    public void readeItem(Long id, Item item);
    public void updateStock(Long id, Long call);
    public void adddItem(Item item);
    public List<Item> getProviderItem();
}

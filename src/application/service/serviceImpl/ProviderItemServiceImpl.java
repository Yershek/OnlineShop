package application.service.serviceImpl;

import application.data.ProviderItemData;
import application.entity.Shop.Item;
import application.service.ProviderItemService;

import java.util.List;

public class ProviderItemServiceImpl implements ProviderItemService {
    ProviderItemData providerItemData;

    @Override
    public Long getProviderinfoItem() {
        return providerItemData.getProviderinfoItem();
    }

    @Override
    public void setProviderinfoItem(){
        providerItemData.setProviderinfoItem();
    }
    @Override
    public void readeItem(Long id, Item item){
        providerItemData.getProviderItem().set(Math.toIntExact(id), item);
    }

    @Override
    public void updateStock(Long id, Long call){
        providerItemData.getProviderItem().get(Math.toIntExact(id)).setCall(call);
    }

    @Override
    public void adddItem(Item item) {
        providerItemData.adddItem(item);
    }

    @Override
    public List<Item> getProviderItem() {
        return List.of();
    }
}

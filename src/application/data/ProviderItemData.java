package application.data;

import application.entity.Shop.Item;

import java.util.ArrayList;
import java.util.List;

public class ProviderItemData {
    protected List<Item> providerItem;
    protected Long id;
    protected Long providerinfoItem = 0L;

    public Long getProviderinfoItem(){
        return providerinfoItem;
    }

    public void setProviderinfoItem(){
        providerinfoItem = id;
    }

    public ProviderItemData(){
        this.id = 0L;
        this.providerItem = new ArrayList<>();
    }

    public List<Item> getProviderItem() {
        return providerItem;
    }

    public void adddItem(Item item){
        item.setId(id++);
        providerItem.add(item);
    }
}

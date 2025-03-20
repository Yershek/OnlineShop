package application.entity.Shop;

import application.entity.Entity;

public class Item {
    private Long id;
    private String itemName;
    private Long itemPrice;
    private Entity userGeneral;
    private Long call;
    private String review;

    public Long getId() {
        return id;
    }

    public Item setId(Long id) {
        this.id = id;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public Item setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public Long getCall() {
        return call;
    }

    public void setCall(Long call) {
        this.call = call;
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public Entity getUserGeneral() {
        return userGeneral;
    }

    public void setUserGeneral(Entity userGeneral) {
        this.userGeneral = userGeneral;
    }

    public Item setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
        return this;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", userGeneral=" + userGeneral.getLogin() +
                '}';
    }
}

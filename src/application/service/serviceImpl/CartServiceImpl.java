package application.service.serviceImpl;

import application.data.CartData;
import application.entity.Shop.Item;
import application.exception.ItemsNotFoundException;
import application.service.CartSevice;

import java.util.List;

public class CartServiceImpl implements CartSevice {
    CartData cartData;

    @Override
    public void removeItemById(Long id) {
        for (int i = 0; i < cartData.getCart().size(); i++) {
            if (cartData.getCart().get(i).getId().equals(id)) {
                cartData.getCart().remove(i);
            }
        }
        throw new ItemsNotFoundException("такого продукта нет");
    }

    @Override
    public void addCart(Item item) {
        cartData.addCart(item);
    }

    @Override
    public List<Item> getCart() {
        return cartData.getCart();
    }
}

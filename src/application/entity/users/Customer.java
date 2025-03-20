package application.entity.users;

import application.entity.Entity;
import application.entity.enums.UserType;

public class Customer extends Entity {
    public Customer() {
        this.userType = UserType.CUSTOMER;
    }
}

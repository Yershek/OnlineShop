package application.entity.users;

import application.entity.Entity;
import application.entity.enums.UserType;

public class Provider extends Entity {
    public Provider() {
        this.userType = UserType.PROVIDER;
    }
}

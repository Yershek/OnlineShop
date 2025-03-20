package application.entity.users;

import application.entity.Entity;
import application.entity.enums.UserType;

public class Sailsman extends Entity {
    public Sailsman() {
        this.userType = UserType.SAILSMAN;
    }
}

package application.entity.enums;

import application.entity.create_users.CreateUsers;
import application.entity.create_users.new_user.CreateNewCustomer;
import application.entity.create_users.new_user.CreateNewProvider;
import application.entity.create_users.new_user.CreateNewSailsman;

public enum UserType {
    CUSTOMER("Покупатель", new CreateNewCustomer()),
    SAILSMAN("Продовец", new CreateNewSailsman()),
    PROVIDER("Поставщик", new CreateNewProvider());

    private String description;
    private CreateUsers createUsers;

    UserType(String description, CreateUsers createUsers) {
        this.description = description;
        this.createUsers = createUsers;
    }

    public String getDescription() {
        return description;
    }

    public CreateUsers getNewUser(){
        return createUsers;
    }
}

package application.entity.create_users.new_user;

import application.entity.Entity;
import application.entity.create_users.CreateUsers;
import application.entity.users.Customer;

public class CreateNewCustomer implements CreateUsers {
    @Override
    public Entity crateNewUsers() {
        return new Customer();
    }
}

package application.entity.create_users.new_user;

import application.entity.Entity;
import application.entity.create_users.CreateUsers;
import application.entity.users.Sailsman;

public class CreateNewSailsman implements CreateUsers {
    @Override
    public Entity crateNewUsers() {
        return new Sailsman();
    }
}

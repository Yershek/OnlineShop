package application.service;

import application.entity.Entity;

import java.util.List;

public interface UserService {
    public Entity ByLogin(String login);
    public Entity addUser(Entity element);
    public List<Entity> getAll();
    public Entity getId(Long id);
}

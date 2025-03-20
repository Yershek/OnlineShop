package application.service.serviceImpl;

import application.data.UserHendler;
import application.entity.Entity;
import application.exception.UserFoundException;
import application.exception.UserNotFoundException;
import application.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserHendler userHendler;

    @Override
    public Entity ByLogin(String login){
        for(Entity user : userHendler.getAll()){
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        throw new UserNotFoundException("пользователь не найден");
    }

    @Override
    public Entity addUser(Entity element) {
        userHendler.getAll().stream().filter(entity -> entity.getLogin().equals(element.getLogin())).findFirst().ifPresent(entity -> {
            throw new UserFoundException("Такой пользователь есть");
        });
        return userHendler.add(element);
    }

    @Override
    public List<Entity> getAll() {
        return userHendler.getAll();
    }

    @Override
    public Entity getId(Long id) {
        return userHendler.getId(id);
    }

}

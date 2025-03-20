package application.data;

import application.entity.Entity;
import application.exception.ElementNotFoundException;

import java.util.ArrayList;
import java.util.List;

public abstract class UserHendler {
    protected List<Entity> data;
    protected Long id;

    public UserHendler(){
        data = new ArrayList<>();
        this.id = 0L;
    }

    public Entity add(Entity element){
        element.setId(id++);
        data.add(element);
        return element;
    }

    public List<Entity> getAll(){
        return data;
    }


    public Entity getId(Long id){
        for (Entity element : data){
            if(element.getId().equals(id)){
                return element;
            }
        }
        throw new ElementNotFoundException("айди пользователя не найден");
    }
}

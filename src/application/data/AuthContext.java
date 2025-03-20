package application.data;

import application.entity.Entity;
import application.exception.NullAutException;

public class AuthContext {
    private Entity authUser;

    public Entity getAuthUser() {
        if(authUser == null) throw new NullAutException("Вы не авторизованны!");
        return authUser;
    }

    public void setAuthUser(Entity authUser) {
        this.authUser = authUser;
    }

    public void logOut() {
        authUser = null;
    }

    public boolean autification(){
        return authUser != null;
    }
}

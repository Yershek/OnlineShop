package application.entity;

import application.entity.enums.UserType;

import java.util.List;

public abstract class Entity {
    protected Long id;
    protected Long messageId = 0L;
    protected Long messageinfo = 0L;
    protected String login;
    protected String possword;
    protected UserType userType;
    protected List<Message> messages;

    public Long getMessageinfo() {
        return messageinfo;
    }

    public void setMessageinfo() {
        this.messageinfo = (long) messages.size();
    }

    public List<Message> getAllMessages(){
        return messages;
    }

    public Message getMessagesId(Long id) {
        return messages.get(Math.toIntExact(id));
    }

    public void addMessages(Message messages) {
        messages.setId(messageId);
        this.messages.add(messages);
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPossword() {
        return possword;
    }

    public void setPossword(String possword) {
        this.possword = possword;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", login= " + login;
    }
}

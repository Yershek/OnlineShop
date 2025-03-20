package application.entity;

public class Posts {
    private Long id;
    private String teg;
    private String content;
    private Entity postsType;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entity getPostsType() {
        return postsType;
    }

    public void setPostsType(Entity postsType) {
        this.postsType = postsType;
    }

    public String getTeg() {
        return teg;
    }

    public void setTeg(String teg) {
        this.teg = teg;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "content='" + content + '\'' +
                ", id=" + id +
                ", title='" + teg + '\'' +
                ", login '" +postsType.getLogin() + '\'' +
                ", type '" + postsType.getUserType() + '\'' +
                '}';
    }
}

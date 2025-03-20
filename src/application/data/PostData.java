package application.data;

import application.entity.Posts;

import java.util.ArrayList;
import java.util.List;

public class PostData {
    protected List<Posts> posts;
    protected Long id;

    public PostData() {
        id=0L;
        posts = new ArrayList<>();
    }

    public void addPosts(Posts posts){
        posts.setId(id++);
        this.posts.add(posts);
    }

    public List<Posts> getPosts(){
        return posts;
    }
}

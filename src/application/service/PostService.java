package application.service;

import application.entity.Posts;

import java.util.List;

public interface PostService {
    public void removePosts(Posts posts);
    public Posts getPostById(Long id);
    public Posts getPostByTeg(String teg);
    public Posts getPostsByLogin(String login);
    public void addPosts(Posts posts);
    public List<Posts> getPosts();
}

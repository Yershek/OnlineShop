package application.service.serviceImpl;


import application.data.PostData;
import application.entity.Posts;
import application.exception.PostsException;
import application.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    PostData postData;

    @Override
    public void removePosts(Posts posts){
        this.postData.getPosts().remove(posts);
    }

    @Override
    public Posts getPostById(Long id){
        for(Posts element : postData.getPosts()){
            if(element.getId().equals(id)){
                return element;
            }
        }
        throw new PostsException("Пост не найден");
    }

    @Override
    public Posts getPostByTeg(String teg){
        for (Posts element : postData.getPosts()){
            if(element.getTeg().equals(teg)){
                return element;
            }
        }
        throw new PostsException("Пост не найден");
    }

    @Override
    public Posts getPostsByLogin(String login){
        for(Posts element : postData.getPosts()){
            if(element.getPostsType().getLogin().equals(login)){
                return element;
            }
        }
        throw new PostsException("Пост не найден");
    }

    @Override
    public void addPosts(Posts posts) {
        postData.addPosts(posts);
    }

    @Override
    public List<Posts> getPosts() {
        return postData.getPosts();
    }

}

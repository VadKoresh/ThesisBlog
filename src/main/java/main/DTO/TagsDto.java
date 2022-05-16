package main.DTO;

import main.model.PostsEntity;

import java.util.List;

public class TagsDto {

    private int id;
    private String name;
    private List<PostsEntity> postsEntityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostsEntity> getPostsEntityList() {
        return postsEntityList;
    }

    public void setPostsEntityList(List<PostsEntity> postsEntityList) {
        this.postsEntityList = postsEntityList;
    }
}

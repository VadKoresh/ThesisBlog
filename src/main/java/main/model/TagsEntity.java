package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tags")
public class TagsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "tag_id")
    private int id;

    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(
            name = "tag2post"
            , joinColumns = @JoinColumn(name = "tag_id")
            , inverseJoinColumns = @JoinColumn(name = "post_id")
    )
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

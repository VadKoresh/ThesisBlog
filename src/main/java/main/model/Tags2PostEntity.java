package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tag2post")
public class Tags2PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private PostsEntity postId;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private TagsEntity tagId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PostsEntity getPostId() {
        return postId;
    }

    public void setPostId(PostsEntity postId) {
        this.postId = postId;
    }

    public TagsEntity getTagId() {
        return tagId;
    }

    public void setTagId(TagsEntity tagId) {
        this.tagId = tagId;
    }
}

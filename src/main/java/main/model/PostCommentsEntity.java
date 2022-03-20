package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_comments")
public class PostCommentsEntity {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private PostCommentsEntity parentId;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private PostsEntity postId;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity userId;
    @NotNull
    private LocalDateTime time;
    @NotNull
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PostCommentsEntity getParentId() {
        return parentId;
    }

    public void setParentId(PostCommentsEntity parentId) {
        this.parentId = parentId;
    }

    public PostsEntity getPostId() {
        return postId;
    }

    public void setPostId(PostsEntity postId) {
        this.postId = postId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
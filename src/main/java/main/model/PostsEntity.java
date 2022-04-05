package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostsEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "is_active")
    private byte isActive;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "moderation_status")
    private ModerationStatus moderationStatus;

    @Column(name = "moderator_id")
    private int moderatorId;

    @NotNull
    private LocalDateTime time;

    @NotNull
    private String title;

    @NotNull
    private String text;

    @NotNull
    @Column(name = "view_count")
    private int viewCount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @NotNull
    private UserEntity userId;

    @OneToMany(cascade = CascadeType.ALL
            , mappedBy = "postId")
    private List<PostVotesEntity> postVotesEntityList;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tag2post"
            , joinColumns = @JoinColumn(name = "tag_id")
            , inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private List<TagsEntity> tagsEntityList;

    @OneToMany(cascade = CascadeType.ALL
            , mappedBy = "postId")
    private List<PostCommentsEntity> commentsEntityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    public ModerationStatus getModerationStatus() {
        return moderationStatus;
    }

    public void setModerationStatus(ModerationStatus moderationStatus) {
        this.moderationStatus = moderationStatus;
    }

    public int getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(int moderatorId) {
        this.moderatorId = moderatorId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public List<PostVotesEntity> getPostVotesEntityList() {
        return postVotesEntityList;
    }

    public void setPostVotesEntityList(List<PostVotesEntity> postVotesEntityList) {
        this.postVotesEntityList = postVotesEntityList;
    }

    public List<TagsEntity> getTagsEntityList() {
        return tagsEntityList;
    }

    public void setTagsEntityList(List<TagsEntity> tagsEntityList) {
        this.tagsEntityList = tagsEntityList;
    }

    public List<PostCommentsEntity> getCommentsEntityList() {
        return commentsEntityList;
    }

    public void setCommentsEntityList(List<PostCommentsEntity> commentsEntityList) {
        this.commentsEntityList = commentsEntityList;
    }
}

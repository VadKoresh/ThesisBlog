package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class PostsEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Column(name = "is_active")
    private byte isActive;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "moderation_status")
    private ModerationStatus moderationStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity moderatorId;
    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    private UserEntity userId;
    @NotNull
    private LocalDateTime time;
    @NotNull
    private String title;
    @NotNull
    private String text;
    @NotNull
    @Column(name = "view_count")
    private int viewCount;

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

    public UserEntity getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(UserEntity moderatorId) {
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
}

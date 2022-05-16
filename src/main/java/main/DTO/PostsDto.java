package main.DTO;

import main.model.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class PostsDto {

    private int id;
    private byte isActive;
    private ModerationStatus moderationStatus;
    private Integer moderatorId;
    private Date time;
    private String title;
    private String text;
    private int viewCount;
    private UserEntity userId;
    private List<PostVotesEntity> postVotesEntityList;
    private List<TagsEntity> tagsEntityList;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public void setModeratorId(Integer moderatorId) {
        this.moderatorId = moderatorId;
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

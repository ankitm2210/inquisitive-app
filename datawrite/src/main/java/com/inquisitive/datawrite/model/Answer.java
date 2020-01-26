package com.inquisitive.datawrite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by ankitmishra on 27/01/20.
 */

@Entity
@Table(name = "answers")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class Answer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long qId;
    String title;
    String description;
    Boolean hasPicture;
    Boolean hasVideo;
    Long votesCount;
    @Enumerated(EnumType.STRING)
    PostStatus questionStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    @JsonInclude()
    @Transient
    private List<Tag> tags;

    public Answer(Long qId, String title, String description, Boolean hasPicture, Boolean hasVideo, Long votesCount, PostStatus questionStatus) {
        this.qId = qId;
        this.title = title;
        this.description = description;
        this.hasPicture = hasPicture;
        this.hasVideo = hasVideo;
        this.votesCount = votesCount;
        this.questionStatus = questionStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getqId() {
        return qId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getHasPicture() {
        return hasPicture;
    }

    public Boolean getHasVideo() {
        return hasVideo;
    }

    public Long getVotesCount() {
        return votesCount;
    }

    public PostStatus getQuestionStatus() {
        return questionStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setqId(Long qId) {
        this.qId = qId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHasPicture(Boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public void setHasVideo(Boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public void setVotesCount(Long votesCount) {
        this.votesCount = votesCount;
    }

    public void setQuestionStatus(PostStatus questionStatus) {
        this.questionStatus = questionStatus;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}

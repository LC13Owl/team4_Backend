package com.example.likelion4_2.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "diary")
public class DiaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String nickname;
    private String emotion;
    private String content;
    private String tags;
    private String question;
    private String photoUrl;
    private boolean isPublic;

    @CreationTimestamp
    private LocalDateTime createdAt;  // 작성일 자동 기록

    public DiaryEntity() {}

    public DiaryEntity(String title, String nickname, String emotion, String content, String tags, String question, String photoUrl, boolean isPublic) {
        this.title = title;
        this.nickname = nickname;
        this.emotion = emotion;
        this.content = content;
        this.tags = tags;
        this.question = question;
        this.photoUrl = photoUrl;
        this.isPublic = isPublic;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getEmotion() { return emotion; }
    public void setEmotion(String emotion) { this.emotion = emotion; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

    public boolean isPublic() { return isPublic; }
    public void setPublic(boolean isPublic) { this.isPublic = isPublic; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

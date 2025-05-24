package com.example.likelion4_2.dto;

import java.time.LocalDateTime;

public class DiaryDto {
    public int id;
    public String title;
    public String nickname;
    public String emotion;
    public String content;
    public String tags;
    public String question;
    public String photoUrl;
    public boolean isPublic;
    public LocalDateTime createdAt;  // 추가

    public DiaryDto() {}

    public DiaryDto(int id, String title, String nickname, String emotion, String content, String tags, String question, String photoUrl, boolean isPublic, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.nickname = nickname;
        this.emotion = emotion;
        this.content = content;
        this.tags = tags;
        this.question = question;
        this.photoUrl = photoUrl;
        this.isPublic = isPublic;
        this.createdAt = createdAt;
    }

    // Getter, Setter 모두 추가

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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

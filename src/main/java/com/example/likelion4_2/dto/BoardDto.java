package com.example.likelion4_2.dto;

public class BoardDto {
    public int id;
    public String title;
    public String content;
    public String userId; // 추가됨
    public String emotion; // 추가됨

    public BoardDto() {}

    public BoardDto(int id, String title, String content, String userId, String emotion) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.emotion = emotion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getEmotion() { return emotion; }
    public void setEmotion(String emotion) { this.emotion = emotion; }
}

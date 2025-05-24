package com.example.likelion4_2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String title;

    @Column(length = 500)
    private String content;

    private String userId;
    private String emotion;

    public BoardEntity() {}

    public BoardEntity(String title, String content, String userId, String emotion) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.emotion = emotion;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getEmotion() { return emotion; }
    public void setEmotion(String emotion) { this.emotion = emotion; }
}
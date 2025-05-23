package com.example.likelion4_2.dto;

public class BoardDto {
    public int id;
    public String title;
    public String content;

    public BoardDto(){}

    public BoardDto(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;

    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

}

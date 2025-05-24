package com.example.likelion4_2.service;

import com.example.likelion4_2.dto.DiaryDto;

import java.util.List;

public interface DiaryService {
    void writeDiary(DiaryDto diaryDto);
    List<DiaryDto> getAllDiaries();
    DiaryDto getDiaryById(int id);
    void updateDiary(int id, DiaryDto diaryDto);
    void deleteDiary(int id);
    List<DiaryDto> filterByEmotion(String emotion);
    List<DiaryDto> getAllDiariesByLatest();  // 최신순 조회
}

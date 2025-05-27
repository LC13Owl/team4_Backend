package com.example.likelion4_2.service;

import com.example.likelion4_2.dto.DiaryDto;

import java.util.List;

public interface DiaryService {
    void writeDiary(DiaryDto diaryDto); //일기 작성
    List<DiaryDto> getAllDiaries(); //모든 일기 가져오기
    DiaryDto getDiaryById(int id); //특정 ID의 일기 조회
    void updateDiary(int id, DiaryDto diaryDto); //특정 일기 수정
    void deleteDiary(int id); //특정 일기 삭제
    List<DiaryDto> filterByEmotion(String emotion); //감정별 필터링
    List<DiaryDto> getAllDiariesByLatest();  // 최신순 정렬
}

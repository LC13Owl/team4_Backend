package com.example.likelion4_2.controller;

import com.example.likelion4_2.dto.DiaryDto;
import com.example.likelion4_2.service.DiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/create") //일기 생성
    public ResponseEntity<String> writeDiary(@RequestBody DiaryDto dto) {
        diaryService.writeDiary(dto);
        return ResponseEntity.ok("일기 저장 완료");
    }

    @GetMapping("/read") //모든 일기를 리스트 형태로 조회
    public List<DiaryDto> getAll() {
        return diaryService.getAllDiaries();
    }

    @GetMapping("/read/{id}") //id에 해당하는 일기 조회
    public DiaryDto getById(@PathVariable int id) {
        return diaryService.getDiaryById(id);
    }

    @PutMapping("/update/{id}") //ID별 일기 수정
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody DiaryDto dto) {
        diaryService.updateDiary(id, dto);
        return ResponseEntity.ok("일기 수정 완료");
    }

    @DeleteMapping("/delete/{id}") //ID별 일기 삭제
    public ResponseEntity<String> delete(@PathVariable int id) {
        diaryService.deleteDiary(id);
        return ResponseEntity.ok("일기 삭제 완료");
    }

    @GetMapping("/filter/emotion/{emotion}") //감정별 필터링
    public List<DiaryDto> filterByEmotion(@PathVariable String emotion) {
        return diaryService.filterByEmotion(emotion);
    }

    @GetMapping("/latest") //최신순으로 일기 정렬
    public List<DiaryDto> getLatestDiaries() {
        return diaryService.getAllDiariesByLatest();
    }
}

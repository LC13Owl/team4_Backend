package com.example.likelion4_2.controller;

import com.example.likelion4_2.dto.DiaryDto;
import com.example.likelion4_2.service.DiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") //React에서 오는 요청 허용
@RestController //이 클래스가 REST API의 컨트롤러임을 나타냄(응답값은 JSON 형태)
@RequestMapping("/diaries") //이 컨트롤러가 처리할 URL의 기본 경로를 /diaries로 지정
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {//생성자 통해 DiaryService 주입
        this.diaryService = diaryService;
    }

    @PostMapping("/create") //일기 생성
    public ResponseEntity<String> writeDiary(@RequestBody DiaryDto dto) {
        diaryService.writeDiary(dto);
        return ResponseEntity.ok("일기 저장 완료");
    }

    //@RequestBody DiaryDto dto가 자동으로 이걸 DiaryDto 클래스의 객체로 바꿔
    //ResponseEntity<String> :백엔드가 프론트에 응답줄 때 쓰는 객체. 상태코드:200 OK와 본문(Body):일기저장완료를 함께 줌

    @GetMapping("/read") //모든 일기를 리스트 형태로 조회
    public List<DiaryDto> getAll() {
        return diaryService.getAllDiaries();
    }

    //DiaryService 클래스에 있는 getAllDiaries() 메서드를 실행해서 그 결과를 그대로 반환

    @GetMapping("/read/{id}") //id에 해당하는 일기 조회
    public DiaryDto getById(@PathVariable int id) {
        return diaryService.getDiaryById(id);
    }
    //@PathVariable: URL 경로에 있는 값을 변수로 받아옴

    @PutMapping("/update/{id}") //ID별 일기 수정
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody DiaryDto dto) {
        diaryService.updateDiary(id, dto);//id에 해당하는 일기를 dto 내용으로 바꿔줘
        return ResponseEntity.ok("일기 수정 완료");
    }

    //@RequestBody DiaryDto dto
    //프론트엔드에서 수정할 일기 내용(JSON) 을 보내면
    //그 JSON을 DiaryDto 객체로 바꿔서 받아와
    //즉, 수정할 새 제목/내용/감정이 여기에 들어있음

    @DeleteMapping("/delete/{id}") //ID별 일기 삭제
    public ResponseEntity<String> delete(@PathVariable int id) {
        diaryService.deleteDiary(id);
        return ResponseEntity.ok("일기 삭제 완료");
    }

    @GetMapping("/filter/emotion/{emotion}") //감정별 필터링
    public List<DiaryDto> filterByEmotion(@PathVariable String emotion) {
        return diaryService.filterByEmotion(emotion);
    }

    //@PathVariable String emotion:URL 경로의 값을 자바 메서드 매개변수로 받겠다는 뜻
    //예: /filter/emotion/sad → emotion = "sad" 로 저장됨.
    //List<DiaryDto> filterByEmotion(...):반환타입이 List<DiaryDto>니까, 여러 개의 일기(DiaryDto) 를 담은 리스트가 결과
    //클라이언트가 /diaries/filter/emotion/happy 요청
    //emotion 변수에는 "happy"가 들어옴
    //서비스에서 happy 감정을 가진 일기들만 골라서 리스트로 돌려줌
    //클라이언트는 그 리스트를 화면에 보여줄 수 있음
    //List<DiaryDto>를 리턴하는 이유: 사용자가 요청한 조건에 맞는 여러 개의 일기를 보여줘야 해서

    @GetMapping("/latest") //최신순으로 일기 정렬
    public List<DiaryDto> getLatestDiaries() {
        return diaryService.getAllDiariesByLatest();
    }
    //List<DiaryDto>는 리스트 리턴타입
}

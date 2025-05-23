package com.example.likelion4_2.controller;

import com.example.likelion4_2.dto.BoardDto;
import com.example.likelion4_2.service.BoardService; // ⭐ 이 줄이 꼭 필요해!
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // POST 요청: 게시글 저장
    @PostMapping("/create")
    public ResponseEntity<String> createBoard(@RequestBody BoardDto boardDto) {
        boardService.createBoard(boardDto);
        return ResponseEntity.ok("게시글이 등록되었습니다");
    }

    // GET 요청: 게시글 전체 조회
    @GetMapping("/read")
    public List<BoardDto> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/read/{id}")
    public BoardDto readBoard(@PathVariable int id) {
        return boardService.readById(id);
    }

    @DeleteMapping("/{id}") //삭제
    public ResponseEntity<String> deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok("게시글이 삭제되었습니다");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable int id, @RequestBody BoardDto boardDto) {
        boardService.updateById(id,boardDto);
        return ResponseEntity.ok("게시글 수정됨");
    }
}


//답안예시 쓰다가 만 것
//@PostMapping("/create")
//public void saveBoard(@RequestBody BoardDto boarDto){
//    boardService.save(boarDto);
//}
//
//@GetMapping("/read")
//public
//
//@GetMapping

//보고 쓴 것

//    @DeleteMapping("/delete/{id}")
//    public void deleteBoard(@PathVariable int id)
//    {
//        boardService.deleteById(id);
//    }

//    @PutMapping("/update/{id}")
//    public void updateBoard(@PathVariable int id, @RequestBody BoardDto boardDto) {
//        boardService.updateById(id,boardDto);
//    }
package com.example.likelion4_2.service;

import com.example.likelion4_2.dto.BoardDto;
import com.example.likelion4_2.entity.BoardEntity;

import java.util.List;

// 1. 기능 목록을 정리해둔 인터페이스
public interface BoardService {
    void createBoard(BoardDto boardDto);         // 게시글 생성
    BoardDto readById(int id);
    List<BoardDto> getAllBoards();
    void updateById(int id, BoardDto boardDto);
    void deleteBoard(int id);

}




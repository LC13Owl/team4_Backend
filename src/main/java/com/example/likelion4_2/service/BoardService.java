package com.example.likelion4_2.service;

import com.example.likelion4_2.dto.BoardDto;
import java.util.List;

public interface BoardService {
    void createBoard(BoardDto boardDto);
    BoardDto readById(int id);
    List<BoardDto> getAllBoards();
    List<BoardDto> getBoardsByLatest();
    List<BoardDto> getBoardsByUser(String userId);
    void updateById(int id, BoardDto boardDto);
    void deleteBoard(int id);
}
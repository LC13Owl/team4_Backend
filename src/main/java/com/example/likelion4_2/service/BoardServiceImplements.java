package com.example.likelion4_2.service;

import com.example.likelion4_2.dto.BoardDto;
import com.example.likelion4_2.entity.BoardEntity;
import com.example.likelion4_2.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

@Service
public class BoardServiceImplements implements BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImplements(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override //create
    public void createBoard(BoardDto boardDto) {
        BoardEntity boardEntity = new BoardEntity(boardDto.getTitle(), boardDto.getContent());
        boardRepository.save(boardEntity);
    }

    @Override //read
    public List<BoardDto> getAllBoards() {
        List<BoardEntity> boardEntities = boardRepository.findAll(); // DB에서 전체 조회
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (BoardEntity entity : boardEntities) {
            BoardDto dto = new BoardDto(entity.getId(), entity.getTitle(), entity.getContent());
            boardDtoList.add(dto); // 하나씩 DTO로 변환해서 담기
        }

        return boardDtoList;
    }

    @Override
    public BoardDto readById(int id) {
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다"));
        return new BoardDto(board.getId(), board.getTitle(), board.getContent());
    }

    @Override
    public void deleteBoard(int id) {
        boardRepository.deleteById(id);
    }

    @Override
    public void updateById(int id, BoardDto boardDto) {
        // 예시: id로 엔티티 조회 후 수정
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다"));

        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        boardRepository.save(board);
    }


}



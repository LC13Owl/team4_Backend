package com.example.likelion4_2.service;

import com.example.likelion4_2.dto.BoardDto;
import com.example.likelion4_2.entity.BoardEntity;
import com.example.likelion4_2.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImplements implements BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImplements(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void createBoard(BoardDto boardDto) {
        BoardEntity entity = new BoardEntity(
                boardDto.getTitle(),
                boardDto.getContent(),
                boardDto.getUserId(),
                boardDto.getEmotion()
        );
        boardRepository.save(entity);
    }

    @Override
    public BoardDto readById(int id) {
        BoardEntity board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다"));
        return new BoardDto(board.getId(), board.getTitle(), board.getContent(), board.getUserId(), board.getEmotion());
    }

    @Override
    public List<BoardDto> getAllBoards() {
        List<BoardEntity> entities = boardRepository.findAll();
        return toDtoList(entities);
    }

    @Override
    public List<BoardDto> getBoardsByLatest() {
        List<BoardEntity> entities = boardRepository.findAllByOrderByIdDesc();
        return toDtoList(entities);
    }

    @Override
    public List<BoardDto> getBoardsByUser(String userId) {
        List<BoardEntity> entities = boardRepository.findByUserId(userId);
        return toDtoList(entities);
    }

    @Override
    public void updateById(int id, BoardDto boardDto) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다"));
        entity.setTitle(boardDto.getTitle());
        entity.setContent(boardDto.getContent());
        entity.setEmotion(boardDto.getEmotion());
        boardRepository.save(entity);
    }

    @Override
    public void deleteBoard(int id) {
        boardRepository.deleteById(id);
    }

    private List<BoardDto> toDtoList(List<BoardEntity> entities) {
        List<BoardDto> dtos = new ArrayList<>();
        for (BoardEntity entity : entities) {
            dtos.add(new BoardDto(
                    entity.getId(),
                    entity.getTitle(),
                    entity.getContent(),
                    entity.getUserId(),
                    entity.getEmotion()
            ));
        }
        return dtos;
    }
}

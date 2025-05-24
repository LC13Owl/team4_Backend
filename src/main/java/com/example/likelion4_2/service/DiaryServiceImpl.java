package com.example.likelion4_2.service;

import com.example.likelion4_2.dto.DiaryDto;
import com.example.likelion4_2.entity.DiaryEntity;
import com.example.likelion4_2.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    public void writeDiary(DiaryDto dto) {
        DiaryEntity entity = new DiaryEntity(dto.title, dto.nickname, dto.emotion, dto.content, dto.tags, dto.question, dto.photoUrl, dto.isPublic);
        diaryRepository.save(entity);
    }

    @Override
    public List<DiaryDto> getAllDiaries() {
        List<DiaryEntity> entities = diaryRepository.findAll();
        return toDtoList(entities);
    }

    @Override
    public DiaryDto getDiaryById(int id) {
        DiaryEntity e = diaryRepository.findById(id).orElseThrow(() -> new RuntimeException("일기 없음"));
        return toDto(e);
    }

    @Override
    public void updateDiary(int id, DiaryDto dto) {
        DiaryEntity e = diaryRepository.findById(id).orElseThrow(() -> new RuntimeException("일기 없음"));
        e.setTitle(dto.title);
        e.setContent(dto.content);
        e.setEmotion(dto.emotion);
        e.setNickname(dto.nickname);
        e.setTags(dto.tags);
        e.setQuestion(dto.question);
        e.setPhotoUrl(dto.photoUrl);
        e.setPublic(dto.isPublic);
        diaryRepository.save(e);
    }

    @Override
    public void deleteDiary(int id) {
        diaryRepository.deleteById(id);
    }

    @Override
    public List<DiaryDto> filterByEmotion(String emotion) {
        List<DiaryEntity> entities = diaryRepository.findByEmotion(emotion);
        return toDtoList(entities);
    }

    @Override
    public List<DiaryDto> getAllDiariesByLatest() {
        List<DiaryEntity> entities = diaryRepository.findAllByOrderByCreatedAtDesc();
        return toDtoList(entities);
    }

    // Entity → DTO 변환 메서드
    private DiaryDto toDto(DiaryEntity e) {
        return new DiaryDto(
                e.getId(),
                e.getTitle(),
                e.getNickname(),
                e.getEmotion(),
                e.getContent(),
                e.getTags(),
                e.getQuestion(),
                e.getPhotoUrl(),
                e.isPublic(),
                e.getCreatedAt()
        );
    }

    private List<DiaryDto> toDtoList(List<DiaryEntity> entities) {
        List<DiaryDto> result = new ArrayList<>();
        for (DiaryEntity e : entities) {
            result.add(toDto(e));
        }
        return result;
    }
}

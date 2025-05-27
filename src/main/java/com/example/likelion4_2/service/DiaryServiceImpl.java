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
    public void writeDiary(DiaryDto dto) { //DTO 데이터를 Entity로 바꿔서 저장
        DiaryEntity entity = new DiaryEntity(dto.title, dto.nickname, dto.emotion, dto.content, dto.tags, dto.question, dto.photoUrl, dto.isPublic);
        diaryRepository.save(entity);
    }

    @Override
    public List<DiaryDto> getAllDiaries() { //전체 데이터를 DB에서 가져와서 DTO 리스트로 변환해서 반환.
        List<DiaryEntity> entities = diaryRepository.findAll();
        return toDtoList(entities);
    }

    @Override
    public DiaryDto getDiaryById(int id) { //해당 id의 일기를 찾고, 없으면 예외를 던짐.
        DiaryEntity e = diaryRepository.findById(id).orElseThrow(() -> new RuntimeException("일기 없음"));
        return toDto(e);
    }

    @Override
    public void updateDiary(int id, DiaryDto dto) { //id로 Entity 찾고, 그 내용을 dto로 덮어쓰기.
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
    public void deleteDiary(int id) { //id에 해당하는 일기 삭제
        diaryRepository.deleteById(id);
    }

    @Override
    public List<DiaryDto> filterByEmotion(String emotion) { //감정별로 일치하는 Entity를 찾아 DTO 리스트로 변환 후 반환
        List<DiaryEntity> entities = diaryRepository.findByEmotion(emotion);
        return toDtoList(entities);
    }

    @Override
    public List<DiaryDto> getAllDiariesByLatest() { //최신순으로 정렬한 일기 리스트 반환
        List<DiaryEntity> entities = diaryRepository.findAllByOrderByCreatedAtDesc();
        return toDtoList(entities);
    }

    // Entity → DTO 변환 메서드(DB에서 가져온 Entity 객체를 사용자에게 보여줄 수 있는 형태(DTO)로 바꿈.)
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

    private List<DiaryDto> toDtoList(List<DiaryEntity> entities) { //여러 Entity들을 DTO 리스트로 바꿔주는 유틸 함수.
        List<DiaryDto> result = new ArrayList<>();
        for (DiaryEntity e : entities) {
            result.add(toDto(e));
        }
        return result;
    }
}

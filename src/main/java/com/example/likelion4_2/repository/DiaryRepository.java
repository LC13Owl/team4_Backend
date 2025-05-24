package com.example.likelion4_2.repository;

import com.example.likelion4_2.entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<DiaryEntity, Integer> {
    List<DiaryEntity> findByEmotion(String emotion);
    List<DiaryEntity> findAllByOrderByCreatedAtDesc();  // 최신순 조회용 메서드
}

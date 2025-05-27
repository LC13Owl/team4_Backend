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
//<DiaryEntity, Integer>에서
//DiaryEntity는 이 저장소가 다룰 엔티티 타입
//Integer는 엔티티의 기본 키(primary key)의 타입이 Integer라는 뜻

//List<DiaryEntity> findByEmotion(String emotion);
//이름만 보고도 무슨 기능인지 알 수 있어!
//감정(emotion) 값이 일치하는 DiaryEntity 객체들을 리스트로 반환하는 메서드야
//스프링 데이터 JPA는 이런 이름 규칙을 인식해서, 자동으로 "WHERE emotion = ? " 쿼리를 만들어줘.
//
//List<DiaryEntity> findAllByOrderByCreatedAtDesc();
//이 메서드는 createdAt이라는 컬럼(생성일자) 기준으로 내림차순 정렬된 모든 DiaryEntity 목록을 가져와.
//즉, 최신 순으로 일기들을 가져올 때 쓸 수 있지.
//findAllByOrderBy + 필드명 + Desc가 스프링 데이터 JPA의 쿼리 메서드 네이밍 규칙이야.


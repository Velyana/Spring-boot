package com.example.questionnaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}

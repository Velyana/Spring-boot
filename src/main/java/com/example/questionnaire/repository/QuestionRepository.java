package com.example.questionnaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}

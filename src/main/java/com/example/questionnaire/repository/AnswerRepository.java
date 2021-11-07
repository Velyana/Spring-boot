package com.example.questionnaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.Question;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	@Query(value = "SELECT a from Answer a WHERE a.question = ?1")
	List<Answer> findAnswersByQuestion(Question question);
}

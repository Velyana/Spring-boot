package com.example.questionnaire.service;

import java.util.List;
import java.util.Optional;

import com.example.questionnaire.entity.Question;

public interface QuestionService {

	List<Question> findAll();

	void addQuestion(Question q);

	Optional<Question> findById(int id);
}

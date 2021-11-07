package com.example.questionnaire.service;

import java.util.List;
import java.util.Optional;

import com.example.questionnaire.entity.Question;

public interface QuestionService {

	public List<Question> findAll();

	public void addQuestion(Question q);

	public Optional<Question> findById(int id);
}

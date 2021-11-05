package com.example.questionnaire.repository;

import java.util.List;

import com.example.questionnaire.entity.Question;

public interface QuestionRepository {
	public List<Question> getAll();
	
	public void addQuestion(Question q);
	
	public Question getById(int id);
}

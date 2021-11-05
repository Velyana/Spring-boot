package com.example.questionnaire.service;

import java.util.List;

import com.example.questionnaire.entity.Question;

public interface QuestionService {
	
	public List<Question> getAll();
	
	public void addQuestion(Question q);
	
	public Question getById(int id);
}

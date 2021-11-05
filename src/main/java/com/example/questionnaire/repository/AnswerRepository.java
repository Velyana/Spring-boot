package com.example.questionnaire.repository;

import java.util.List;

import com.example.questionnaire.entity.Answer;

public interface AnswerRepository {
	
	public List<Answer> getAll();
	
	public void addAnswer(Answer a);
}

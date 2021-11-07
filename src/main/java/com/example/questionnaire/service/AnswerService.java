package com.example.questionnaire.service;

import java.util.List;

import com.example.questionnaire.entity.Answer;

public interface AnswerService {

	public List<Answer> findAll();

	public void addAnswer(Answer a);
}

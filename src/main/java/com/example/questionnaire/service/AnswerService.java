package com.example.questionnaire.service;

import java.util.List;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.Question;

public interface AnswerService {

	List<Answer> findAll();

	void addAnswer(Answer a);

	List<Answer> findAnswersByQuestion(Question question);
}

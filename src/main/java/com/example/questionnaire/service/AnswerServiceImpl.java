package com.example.questionnaire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.Question;
import com.example.questionnaire.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public List<Answer> findAll() {
		return answerRepository.findAll();
	}

	@Override
	public void addAnswer(Answer a) {
		answerRepository.save(a);

	}

	@Override
	public List<Answer> findAnswersByQuestion(Question question) {
		return answerRepository.findAnswersByQuestion(question);
	}

}

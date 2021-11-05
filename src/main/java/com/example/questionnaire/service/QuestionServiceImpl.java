package com.example.questionnaire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public List<Question> getAll() {
		return questionRepository.getAll();
	}
	
	@Override
	public void addQuestion(Question q) {
		questionRepository.addQuestion(q);
	}

	@Override
	public Question getById(int id) {
		return questionRepository.getById(id);
	}
}

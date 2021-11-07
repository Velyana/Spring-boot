package com.example.questionnaire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	@Override
	public void addQuestion(Question q) {
		questionRepository.save(q);
	}

	@Override
	public Optional<Question> findById(int id) {
		return questionRepository.findById(id);
	}
}

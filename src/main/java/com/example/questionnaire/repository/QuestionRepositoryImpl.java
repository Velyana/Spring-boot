package com.example.questionnaire.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.Question;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

	private static List<Question> questions = new ArrayList<>();
	
	static {
		questions.add(new Question(1, "Q1"));
		questions.add(new Question(2, "Q2"));
		questions.add(new Question(3, "Q3"));
	}
	
	@Override
	public List<Question> getAll() {
		return questions;
	}
	
	@Override
	public void addQuestion(Question q) {
		questions.add(q);
	}
	
	@Override
	public Question getById(int id) {
		Question result = null;		
		for(Question q : questions) {
			if(q.getId() == id)
				result = q;
		}
		
		return result;
	}
}

/*
package com.example.questionnaire.repository;
 

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.Answer;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository {

	private static List<Answer> answers = new ArrayList<>();

	static {

		answers.add(new Answer(1, 1, "A1"));
		answers.add(new Answer(2, 1, "A2"));
		answers.add(new Answer(3, 2, "A3"));
		answers.add(new Answer(4, 3, "A4"));
		answers.add(new Answer(5, 3, "A5"));
		answers.add(new Answer(6, 3, "A6"));

	}

	@Override
	public List<Answer> getAll() {
		return answers;
	}

	@Override
	public void addAnswer(Answer a) {
		answers.add(a);

	}

}

*/
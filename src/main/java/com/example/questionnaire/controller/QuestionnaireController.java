package com.example.questionnaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.Question;
import com.example.questionnaire.service.AnswerService;
import com.example.questionnaire.service.QuestionService;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@GetMapping("/questions")
	public List<Question> getAllQuestions() {
		final List<Question> questionList = questionService.getAll();
		return questionList;
	}

	@GetMapping("/questions/{id}")
	public Question getQuestionById(@PathVariable int id) {
		final Question question = questionService.getById(id);

		return question;
	}

	@PostMapping("/questions")
	public void createQuestion(@RequestBody Question question) {
		questionService.addQuestion(question);
	}

	@GetMapping("/answers")
	public List<Answer> getAllAnswers() {
		final List<Answer> answerList = answerService.getAll();
		return answerList;
	}

	@PostMapping("/answers")
	public void createAnswer(@RequestBody Answer answer) {
		answerService.addAnswer(answer);
	}

}

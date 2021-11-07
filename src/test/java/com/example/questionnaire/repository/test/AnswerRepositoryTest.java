package com.example.questionnaire.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.Question;
import com.example.questionnaire.repository.AnswerRepository;
import com.example.questionnaire.repository.QuestionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AnswerRepositoryTest {

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionRepository questionRepository;

	private Answer firstAnswer;
	private Answer secondAnswer;
	private Question question;

	@Before
	public void setUp() {
		firstAnswer = new Answer("Answer 1");
		secondAnswer = new Answer("Answer 2");

		question = new Question("Question");
		firstAnswer.setQuestion(question);
		secondAnswer.setQuestion(question);
	}

	@Test
	public void saveAnswerAndFindById() {
		questionRepository.save(question);
		Answer savedAnswer = answerRepository.save(firstAnswer);
		Optional<Answer> foundAnswer = answerRepository.findById(savedAnswer
				.getId());

		assertThat(foundAnswer).isNotNull();
		assertThat(foundAnswer.get()).isEqualTo((firstAnswer));

	}

	@Test
	public void findAllAnswers() {
		questionRepository.save(question);
		answerRepository.save(firstAnswer);
		answerRepository.save(secondAnswer);
		List<Answer> answers = answerRepository.findAll();

		assertThat(answers).isNotNull();
	}

}

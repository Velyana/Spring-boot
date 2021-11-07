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

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.repository.QuestionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QuestionRepositoryTest {

	@Autowired
	private QuestionRepository questionRepository;

	private Question firstQuestion;
	private Question secondQuestion;

	@Before
	public void setUp() {
		firstQuestion = new Question("Question 1");
		secondQuestion = new Question("Question 2");
	}

	@Test
	public void saveQuestionAndFindById() {
		Question savedQuestion = questionRepository.saveAndFlush(firstQuestion);
		Optional<Question> foundQuestion = questionRepository
				.findById(savedQuestion.getId());

		assertThat(foundQuestion).isNotNull();
		assertThat(foundQuestion.get()).isEqualTo((firstQuestion));

	}

	@Test
	public void findAllQuestions() {
		questionRepository.saveAndFlush(firstQuestion);
		questionRepository.saveAndFlush(secondQuestion);
		List<Question> questions = questionRepository.findAll();

		assertThat(questions).isNotNull();
	}
	
	@Test
	public void deleteQuestions() {
		questionRepository.saveAndFlush(firstQuestion);
		questionRepository.saveAndFlush(secondQuestion);
		questionRepository.deleteAll();
		
		assertThat(questionRepository.findAll()).isEmpty();
	}
}

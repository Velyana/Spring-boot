package com.example.questionnaire.entity.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.questionnaire.entity.Question;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QuestionTest {

	@Autowired
	private TestEntityManager entityManager;

	private Question firstQuestion;

	@Before
	public void setUp() {
		firstQuestion = new Question("Question 1");
	}

	@Test
	public void saveQuestion() {
		Question savedQuestion = this.entityManager
				.persistAndFlush(firstQuestion);

		assertThat(savedQuestion).isNotNull();
		assertThat(savedQuestion.getQuestion()).isEqualTo("Question 1");
	}

	@Test
	public void findQuestion() {
		Question savedQuestion = this.entityManager
				.persistAndFlush(firstQuestion);
		assertThat(savedQuestion.getQuestion()).isNotNull();

		int id = (int) this.entityManager.getId(savedQuestion);
		Question question = this.entityManager.find(Question.class, id);

		assertThat(question.getQuestion()).isEqualTo("Question 1");
	}

}

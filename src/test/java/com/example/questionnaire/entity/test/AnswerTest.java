package com.example.questionnaire.entity.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.Question;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnswerTest {

	@Autowired
	private TestEntityManager entityManager;

	private Answer firstAnswer;

	@Before
	public void setUp() {
		firstAnswer = new Answer("Answer 1");
	}

	@Test
	public void saveQuestion() {
		Answer savedAnswer = this.entityManager.persistAndFlush(firstAnswer);

		assertThat(savedAnswer).isNotNull();
		assertThat(savedAnswer.getQuestion()).isEqualTo("Answer 1");
	}

	@Test
	public void findQuestion() {
		Answer savedAnswer = this.entityManager.persistAndFlush(firstAnswer);

		assertThat(savedAnswer.getQuestion()).isNotNull();

		int id = (int) this.entityManager.getId(savedAnswer);
		Question question = this.entityManager.find(Question.class, id);

		assertThat(question.getQuestion()).isEqualTo("Answer 1");
	}

}

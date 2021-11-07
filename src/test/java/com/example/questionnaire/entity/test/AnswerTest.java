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

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.Question;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AnswerTest {

	@Autowired
	private TestEntityManager entityManager;

	private Answer firstAnswer;

	private Question question;

	@Before
	public void setUp() {
		question = new Question("Question");
		firstAnswer = new Answer("Answer 1", question);
	}

	@Test
	public void saveAnswer() {
		this.entityManager.persistAndFlush(question);
		Answer savedAnswer = this.entityManager.persistAndFlush(firstAnswer);

		assertThat(savedAnswer).isNotNull();
		assertThat(savedAnswer.getAnswer()).isEqualTo("Answer 1");
	}

	@Test
	public void findAnswer() {
		this.entityManager.persistAndFlush(question);
		Answer savedAnswer = this.entityManager.persistAndFlush(firstAnswer);

		assertThat(savedAnswer.getAnswer()).isNotNull();

		int id = (int) this.entityManager.getId(savedAnswer);
		Answer answer = this.entityManager.find(Answer.class, id);

		assertThat(answer.getAnswer()).isEqualTo("Answer 1");
	}

}

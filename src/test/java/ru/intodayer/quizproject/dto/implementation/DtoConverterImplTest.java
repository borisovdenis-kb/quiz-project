package ru.intodayer.quizproject.dto.implementation;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.intodayer.quizproject.QuizProjectApplication;
import ru.intodayer.quizproject.dto.AnswerDto;
import ru.intodayer.quizproject.dto.DtoConverter;
import ru.intodayer.quizproject.dto.QuestionDto;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.Question;
import ru.intodayer.quizproject.repository.QuestionRepository;

import java.io.IOException;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = QuizProjectApplication.class)
public class DtoConverterImplTest {

    @Autowired
    private DtoConverter dtoConverter;

    @Autowired
    private QuestionRepository questionRepository;

    private ObjectMapper objectMapper;

    @Before
    public void init() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void convertQuestionToDto() throws IOException {
        Question question = questionRepository.findOne(1L);
        QuestionDto questionDto = dtoConverter.convertQuestionToDto(question);

        System.out.println(objectMapper.writeValueAsString(questionDto));
    }

    @Test
    public void convertDtoToAnswer() {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswer("Я знаю, что ничего не знаю...");
        answerDto.setPlayerId(1L);
        answerDto.setQuestionId(1L);

        Answer answer = dtoConverter.convertDtoToAnswer(answerDto);

        System.out.println(answer);
    }
}
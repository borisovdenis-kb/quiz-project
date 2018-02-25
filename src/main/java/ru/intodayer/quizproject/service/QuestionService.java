package ru.intodayer.quizproject.service;

import ru.intodayer.quizproject.dto.QuestionDto;
import ru.intodayer.quizproject.model.Question;
import java.util.List;


public interface QuestionService {

    List<Question> getAllQuestions();

    List<QuestionDto> getAllQuestionDto();
}

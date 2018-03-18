package ru.intodayer.quizproject.service;

import ru.intodayer.quizproject.dto.QuestionDTO;
import ru.intodayer.quizproject.model.Question;
import java.util.List;


public interface QuestionService {

    List<Question> getAllQuestions();

    List<QuestionDTO> getAllQuestionDto();
}

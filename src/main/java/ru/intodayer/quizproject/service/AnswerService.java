package ru.intodayer.quizproject.service;

import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.dto.AnswerExtendedDTO;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.nested.AnswerStatus;
import java.util.List;
import java.util.Map;


public interface AnswerService {

    void addAnswer(Answer answer);

    Map<String, List<AnswerExtendedDTO>> getAnswersGroupedByPlayerName(AnswerStatus answerStatus);

    void updateAnswers(List<AnswerDTO> answerDtoList);
}

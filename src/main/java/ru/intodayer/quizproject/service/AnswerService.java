package ru.intodayer.quizproject.service;

import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.dto.AnswerExtendedDTO;
import ru.intodayer.quizproject.model.AnswerStatus;
import java.util.List;
import java.util.Map;


public interface AnswerService {

    void addAnswer(AnswerDTO answer);

    Map<String, List<AnswerExtendedDTO>> getAnswersGroupedByPlayerName(AnswerStatus answerStatus);
}

package ru.intodayer.quizproject.service;

import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.nested.AnswerStatus;
import java.util.List;
import java.util.Map;


public interface AnswerService {

    void addAnswer(Answer answer);

    Map<String, List<Answer>> getAnswersByQuestionGroupedByPlayerName(Long questionId);

    Map<String, List<Answer>> getAnswersByStatusGroupedByPlayerName(AnswerStatus status);

    void updateAnswers(List<Answer> answerList);
}

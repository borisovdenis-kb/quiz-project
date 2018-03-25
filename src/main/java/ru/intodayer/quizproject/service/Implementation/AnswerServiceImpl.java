package ru.intodayer.quizproject.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.nested.AnswerStatus;
import ru.intodayer.quizproject.repository.AnswerRepository;
import ru.intodayer.quizproject.service.AnswerService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public Map<String, Answer> getAnswersByQuestionGroupedByPlayerName(Long questionId) {
        return answerRepository.findAllByQuestionId(questionId)
                .stream()
                .collect(Collectors.toMap(a -> a.getPlayer().getName(), a -> a));
    }

    @Override
    public Map<String, List<Answer>> getAnswersByStatusGroupedByPlayerName(AnswerStatus status) {
        return this.groupAnswersByPlayerName(answerRepository.findAllByStatus(status));
    }

    @Override
    public void updateAnswers(List<Answer> answerList) {
        answerRepository.save(answerList);
    }

    private Map<String, List<Answer>> groupAnswersByPlayerName(List<Answer> answers) {
        return answers.stream()
                .collect(Collectors.groupingBy(answer -> answer.getPlayer().getName()));
    }
}

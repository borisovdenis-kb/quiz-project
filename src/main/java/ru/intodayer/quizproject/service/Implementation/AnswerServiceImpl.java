package ru.intodayer.quizproject.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.dto.AnswerExtendedDTO;
import ru.intodayer.quizproject.dto.converter.DTOConverter;
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

    @Autowired
    @Qualifier("answerDtoConverter")
    private DTOConverter<Answer, AnswerDTO> answerDtoConverter;

    @Autowired
    @Qualifier("answerExtendedDtoConverter")
    private DTOConverter<Answer, AnswerExtendedDTO> answerExtendedDtoConverter;

    @Override
    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public Map<String, List<Answer>> getAnswersByQuestionGroupedByPlayerName(Long questionId) {
        return this.groupAnswersByPlayerName(answerRepository.findAllByQuestionId(questionId));
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

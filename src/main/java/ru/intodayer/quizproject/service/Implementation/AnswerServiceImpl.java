package ru.intodayer.quizproject.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.dto.AnswerExtendedDTO;
import ru.intodayer.quizproject.dto.converter.DTOConverter;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.AnswerStatus;
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
    public void addAnswer(AnswerDTO answerDto) {
        answerRepository.save(answerDtoConverter.convertDTOToEntity(answerDto));
    }

    @Override
    public Map<String, List<AnswerExtendedDTO>> getAnswersGroupedByPlayerName(AnswerStatus answerStatus) {
        return answerRepository.findAllByStatus(answerStatus)
                .stream()
                .map(answer -> answerExtendedDtoConverter.convertEntityToDTO(answer))
                .collect(Collectors.groupingBy(answerDto -> answerDto.getPlayer().getName()));
    }

    @Override
    public void updateAnswers(List<AnswerDTO> answerDtoList) {
        answerRepository.save(
                answerDtoList
                        .stream()
                        .map(answerDto -> answerDtoConverter.convertDTOToEntity(answerDto))
                        .collect(Collectors.toList())
        );
    }
}

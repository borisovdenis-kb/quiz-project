package ru.intodayer.quizproject.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.intodayer.quizproject.dto.AnswerDto;
import ru.intodayer.quizproject.dto.DtoConverter;
import ru.intodayer.quizproject.repository.AnswerRepository;
import ru.intodayer.quizproject.service.AnswerService;


@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private DtoConverter dtoConverter;

    @Override
    public void addAnswer(AnswerDto answerDto) {
        answerRepository.save(dtoConverter.convertDtoToAnswer(answerDto));
    }
}

package ru.intodayer.quizproject.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.intodayer.quizproject.dto.converter.DTOConverter;
import ru.intodayer.quizproject.dto.QuestionDTO;
import ru.intodayer.quizproject.model.Question;
import ru.intodayer.quizproject.repository.QuestionRepository;
import ru.intodayer.quizproject.service.QuestionService;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    @Qualifier("questionDtoConverter")
    private DTOConverter<Question, QuestionDTO> dtoConverter;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<List<Question>> getAllQuestionGroupedByRound() {
        return this.getAllQuestions()
                .stream()
                .collect(Collectors.groupingBy(q -> q.getRound().getNumber())).entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}

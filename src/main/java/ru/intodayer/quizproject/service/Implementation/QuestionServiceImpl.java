package ru.intodayer.quizproject.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.intodayer.quizproject.dto.DtoConverter;
import ru.intodayer.quizproject.dto.QuestionDto;
import ru.intodayer.quizproject.model.Question;
import ru.intodayer.quizproject.repository.QuestionRepository;
import ru.intodayer.quizproject.service.QuestionService;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private DtoConverter dtoConverter;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<QuestionDto> getAllQuestionDto() {
        List<Question> questionList = getAllQuestions();
        return convertQuestionListToDtoList(questionList);
    }

    private List<QuestionDto> convertQuestionListToDtoList(List<Question> questions) {
        return questions.stream()
                .map( q -> dtoConverter.convertQuestionToDto(q) )
                .collect(Collectors.toList());
    }
}

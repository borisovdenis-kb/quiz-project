package ru.intodayer.quizproject.dto.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.intodayer.quizproject.dto.AnswerDto;
import ru.intodayer.quizproject.dto.DtoConverter;
import ru.intodayer.quizproject.dto.QuestionDto;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.Question;
import ru.intodayer.quizproject.repository.PlayerRepository;
import ru.intodayer.quizproject.repository.QuestionRepository;


@Component
public class DtoConverterImpl implements DtoConverter {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public QuestionDto convertQuestionToDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setQuestion(question.getQuestion());
        questionDto.setTimeNeededSec(question.getTimeNeededSec());
        questionDto.setRoundNumber(question.getRound().getNumber());
        questionDto.setImageFilePath(question.getImageFilePath());
        questionDto.setSoundFilePath(question.getSoundFilePath());
        questionDto.setFunnyStuffFilePath(question.getFunnyStuffFilePath());
        return questionDto;
    }

    @Override
    public Answer convertDtoToAnswer(AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setAnswer(answerDto.getAnswer());
        answer.setPlayer(playerRepository.findOne(answerDto.getPlayerId()));
        answer.setQuestion(questionRepository.findOne(answerDto.getQuestionId()));
        return answer;
    }
}

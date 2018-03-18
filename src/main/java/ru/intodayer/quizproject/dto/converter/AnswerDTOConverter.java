package ru.intodayer.quizproject.dto.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.repository.PlayerRepository;
import ru.intodayer.quizproject.repository.QuestionRepository;


@Component(value = "answerDtoConverter")
public class AnswerDTOConverter implements DTOConverter<Answer, AnswerDTO> {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Answer convertDTOToEntity(AnswerDTO dto) {
        Answer answer = new Answer();
        answer.setAnswer(dto.getAnswer());
        answer.setPlayer(playerRepository.findOne(dto.getPlayerId()));
        answer.setQuestion(questionRepository.findOne(dto.getQuestionId()));
        return answer;
    }

    @Override
    public AnswerDTO convertEntityToDTO(Answer entity) {
        AnswerDTO answerDto = new AnswerDTO();
        answerDto.setAnswer(entity.getAnswer());
        answerDto.setPlayerId(entity.getPlayer().getId());
        answerDto.setQuestionId(entity.getQuestion().getId());
        return answerDto;
    }
}

package ru.intodayer.quizproject.dto.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.AnswerStatus;
import ru.intodayer.quizproject.repository.PlayerRepository;
import ru.intodayer.quizproject.repository.QuestionRepository;

import java.util.Optional;


@Component(value = "answerDtoConverter")
public class AnswerDTOConverter implements DTOConverter<Answer, AnswerDTO> {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Answer convertDTOToEntity(AnswerDTO dto) {
        Answer answer = new Answer();
        answer.setId(dto.getId());
        answer.setAnswer(dto.getAnswer());
        answer.setPlayer(playerRepository.findOne(dto.getPlayerId()));
        answer.setQuestion(questionRepository.findOne(dto.getQuestionId()));
        answer.setStatus(Optional.ofNullable(dto.getStatus()).orElse(AnswerStatus.NOT_RESOLVED));
        return answer;
    }

    @Override
    public AnswerDTO convertEntityToDTO(Answer entity) {
        AnswerDTO answerDto = new AnswerDTO();
        answerDto.setId(entity.getId());
        answerDto.setAnswer(entity.getAnswer());
        answerDto.setPlayerId(entity.getPlayer().getId());
        answerDto.setQuestionId(entity.getQuestion().getId());
        answerDto.setStatus(entity.getStatus());
        return answerDto;
    }
}

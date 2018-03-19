package ru.intodayer.quizproject.dto.converter;

import org.springframework.stereotype.Component;
import ru.intodayer.quizproject.dto.AnswerExtendedDTO;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.Question;


@Component(value = "answerExtendedDtoConverter")
public class AnswerExtendedConverter implements DTOConverter<Answer, AnswerExtendedDTO> {

    @Override
    public Answer convertDTOToEntity(AnswerExtendedDTO dto) {
        return null;
    }

    @Override
    public AnswerExtendedDTO convertEntityToDTO(Answer entity) {
        Question question = entity.getQuestion();

        AnswerExtendedDTO answerExtendedDto = new AnswerExtendedDTO();
        answerExtendedDto.setId(entity.getId());
        answerExtendedDto.setAnswer(entity.getAnswer());
        answerExtendedDto.setRightAnswer(question.getRightAnswer().getRightAnswer());
        answerExtendedDto.setQuestion(question.getQuestion());
        answerExtendedDto.setPlayerName(entity.getPlayer().getName());
        answerExtendedDto.setStatus(entity.getStatus());
        return answerExtendedDto;
    }
}

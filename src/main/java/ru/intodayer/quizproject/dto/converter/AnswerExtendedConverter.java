package ru.intodayer.quizproject.dto.converter;

import org.springframework.stereotype.Component;
import ru.intodayer.quizproject.dto.AnswerExtendedDTO;
import ru.intodayer.quizproject.model.Answer;

@Component(value = "answerExtendedDtoConverter")
public class AnswerExtendedConverter implements DTOConverter<Answer, AnswerExtendedDTO> {

    @Override
    public Answer convertDTOToEntity(AnswerExtendedDTO dto) {
        return null;
    }

    @Override
    public AnswerExtendedDTO convertEntityToDTO(Answer entity) {
        return null;
    }
}

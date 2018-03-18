package ru.intodayer.quizproject.dto.converter;

import org.springframework.stereotype.Component;
import ru.intodayer.quizproject.dto.QuestionDTO;
import ru.intodayer.quizproject.model.Question;

@Component(value = "questionDtoConverter")
public class QuestionDTOConverter implements DTOConverter<Question, QuestionDTO> {

    @Override
    public Question convertDTOToEntity(QuestionDTO dto) {
        return null;
    }

    @Override
    public QuestionDTO convertEntityToDTO(Question entity) {
        QuestionDTO questionDto = new QuestionDTO();
        questionDto.setId(entity.getId());
        questionDto.setQuestion(entity.getQuestion());
        questionDto.setRightAnswer(entity.getRightAnswer().getRightAnswer());
        questionDto.setTimeNeededSec(entity.getTimeNeededSec());
        questionDto.setRoundNumber(entity.getRound().getNumber());
        questionDto.setImageFilePath(entity.getImageFilePath());
        questionDto.setSoundFilePath(entity.getSoundFilePath());
        questionDto.setFunnyStuffFilePath(entity.getFunnyStuffFilePath());
        return questionDto;
    }
}

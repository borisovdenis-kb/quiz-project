package ru.intodayer.quizproject.dto.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.intodayer.quizproject.dto.AnswerExtendedDTO;
import ru.intodayer.quizproject.dto.PlayerDTO;
import ru.intodayer.quizproject.dto.QuestionDTO;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.Player;
import ru.intodayer.quizproject.model.Question;


@Component(value = "answerExtendedDtoConverter")
public class AnswerExtendedDTOConverter implements DTOConverter<Answer, AnswerExtendedDTO> {

    @Autowired
    @Qualifier("questionDtoConverter")
    private DTOConverter<Question, QuestionDTO> questionDtoConverter;

    @Autowired
    @Qualifier("playerDtoConverter")
    private DTOConverter<Player, PlayerDTO> playerDtoConverter;

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
        answerExtendedDto.setQuestion(questionDtoConverter.convertEntityToDTO(question));
        answerExtendedDto.setPlayer(playerDtoConverter.convertEntityToDTO(entity.getPlayer()));
        answerExtendedDto.setStatus(entity.getStatus());
        return answerExtendedDto;
    }
}

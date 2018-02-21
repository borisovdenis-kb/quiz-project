package ru.intodayer.quizproject.dto;

import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.Question;

public interface DtoConverter {

    QuestionDto convertQuestionToDto(Question question);

    Answer convertDtoToAnswer(AnswerDto answerDto);

}

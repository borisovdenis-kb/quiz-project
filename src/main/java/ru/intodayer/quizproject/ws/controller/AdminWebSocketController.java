package ru.intodayer.quizproject.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.intodayer.quizproject.dto.QuestionDTO;
import ru.intodayer.quizproject.dto.converter.DTOConverter;
import ru.intodayer.quizproject.model.Question;
import ru.intodayer.quizproject.service.QuestionService;
import ru.intodayer.quizproject.ws.message.CommandName;
import ru.intodayer.quizproject.ws.message.MessageToQuiz;
import java.util.*;
import java.util.stream.Collectors;


@Controller
public class AdminWebSocketController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    @Qualifier("questionDtoConverter")
    private DTOConverter<Question, QuestionDTO> dtoConverter;


    @MessageMapping("/app/admin/getCommand")
    @SendTo("/app/client/getCommand")
    public MessageToQuiz getCommand(@Payload MessageToQuiz adminCommandMsg) {
        MessageToQuiz response = new MessageToQuiz();
        response.setCommand(adminCommandMsg.getCommand());

        if (adminCommandMsg.getCommand().getName() == CommandName.LOAD) {
            List<List<QuestionDTO>> questionGroupedByRound = questionService.getAllQuestionGroupedByRound()
                    .stream()
                    .map(this::convertQuestionListToDtoList)
                    .collect(Collectors.toList());

            response.setQuestions(questionGroupedByRound);
        }

        return response;
    }

    private List<QuestionDTO> convertQuestionListToDtoList(List<Question> questions) {
        return questions
                .stream()
                .map(q -> dtoConverter.convertEntityToDTO(q))
                .collect(Collectors.toList());
    }
}

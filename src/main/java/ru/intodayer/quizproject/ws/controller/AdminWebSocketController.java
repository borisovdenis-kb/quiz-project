package ru.intodayer.quizproject.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.intodayer.quizproject.dto.QuestionDto;
import ru.intodayer.quizproject.service.QuestionService;
import ru.intodayer.quizproject.ws.message.CommandName;
import ru.intodayer.quizproject.ws.message.MessageToQuiz;
import java.util.*;
import java.util.stream.Collectors;


@Controller
public class AdminWebSocketController {

    private QuestionService questionService;

    @Autowired
    public AdminWebSocketController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @MessageMapping("/app/admin/getCommand")
    @SendTo("/app/client/getCommand")
    public MessageToQuiz getCommand(@Payload MessageToQuiz adminCommandMsg) {
        MessageToQuiz response = new MessageToQuiz();
        response.setCommand(adminCommandMsg.getCommand());

        if (adminCommandMsg.getCommand().getName() == CommandName.LOAD) {
            List<List<QuestionDto>> questionGroupedByRound = questionService.getAllQuestionDto()
                    .stream()
                    .collect(Collectors.groupingBy(QuestionDto::getRoundNumber)).entrySet()
                    .stream()
                    .map( entry -> entry.getValue() )
                    .collect(Collectors.toList());

            response.setQuestions(questionGroupedByRound);
        }

        return response;
    }
}

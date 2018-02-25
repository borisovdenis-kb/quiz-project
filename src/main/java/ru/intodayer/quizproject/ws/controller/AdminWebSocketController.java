package ru.intodayer.quizproject.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.intodayer.quizproject.dto.DtoConverter;
import ru.intodayer.quizproject.service.QuestionService;
import ru.intodayer.quizproject.ws.message.Command;
import ru.intodayer.quizproject.ws.message.Message;


@Controller
public class AdminWebSocketController {

    private final SimpMessagingTemplate template;

    private QuestionService questionService;

    private DtoConverter dtoConverter;

    @Autowired
    public AdminWebSocketController(
            SimpMessagingTemplate template,
            QuestionService questionService,
            DtoConverter dtoConverter) {
        this.template = template;
        this.questionService = questionService;
        this.dtoConverter = dtoConverter;
    }

    @MessageMapping("/app/admin/getCommand")
    @SendTo("/app/client/getCommand")
    public Message getCommand(@Payload Message adminCommandMsg) {
        Message response = new Message();
        response.setCommand(adminCommandMsg.getCommand());

        if (adminCommandMsg.getCommand() == Command.LOAD) {
            response.setContent(questionService.getAllQuestionDto());
        }
        return response;
    }
}

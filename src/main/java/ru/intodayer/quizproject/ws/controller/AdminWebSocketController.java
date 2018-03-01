package ru.intodayer.quizproject.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.intodayer.quizproject.service.QuestionService;
import ru.intodayer.quizproject.ws.message.CommandName;
import ru.intodayer.quizproject.ws.message.Message;


@Controller
public class AdminWebSocketController {

    private QuestionService questionService;

    @Autowired
    public AdminWebSocketController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @MessageMapping("/app/admin/getCommand")
    @SendTo("/app/client/getCommand")
    public Message getCommand(@Payload Message adminCommandMsg) {
        Message response = new Message();
        response.setCommand(adminCommandMsg.getCommand());

        if (adminCommandMsg.getCommand().getName() == CommandName.LOAD) {
            response.setContent(questionService.getAllQuestionDto());
        }
        return response;
    }
}

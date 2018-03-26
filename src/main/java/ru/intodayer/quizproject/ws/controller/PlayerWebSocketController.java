package ru.intodayer.quizproject.ws.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.intodayer.quizproject.dto.QuestionDTO;
import ru.intodayer.quizproject.ws.message.Message;


@Controller
public class PlayerWebSocketController {

    @MessageMapping("/app/quiz/getCurrentQuestion")
    @SendTo("/app/player/getCurrentQuestion")
    public Message getCurrentQuestion(@Payload Message<QuestionDTO> message) {
        return message;
    }
}

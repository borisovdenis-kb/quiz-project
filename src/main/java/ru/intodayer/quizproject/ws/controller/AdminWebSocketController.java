package ru.intodayer.quizproject.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.dto.QuestionDTO;
import ru.intodayer.quizproject.dto.converter.DTOConverter;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.Question;
import ru.intodayer.quizproject.service.AnswerService;
import ru.intodayer.quizproject.service.QuestionService;
import ru.intodayer.quizproject.ws.message.nested.Command;
import ru.intodayer.quizproject.ws.message.nested.CommandName;
import ru.intodayer.quizproject.ws.message.CommandMessage;
import java.util.*;
import java.util.stream.Collectors;


@Controller
public class AdminWebSocketController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    @Qualifier("questionDtoConverter")
    private DTOConverter<Question, QuestionDTO> questionDtoConverter;

    @Autowired
    @Qualifier("answerDtoConverter")
    private DTOConverter<Answer, AnswerDTO> answerDtoConverter;

    @MessageMapping("/app/admin/command/load")
    @SendTo("/app/client/getCommand")
    public CommandMessage handleLoadCommand(@Payload CommandMessage message) {
        CommandMessage<Object> response = new CommandMessage<>();

        List<List<QuestionDTO>> questionGroupedByRound = questionService.getAllQuestionGroupedByRound()
                .stream()
                .map(this::convertQuestionListToDtoList)
                .collect(Collectors.toList());

        response.setCommand(message.getCommand());
        response.setContent(questionGroupedByRound);

        return response;
    }

    @MessageMapping("/app/admin/command/show_players_answers")
    @SendTo("/app/client/getCommand")
    public CommandMessage handleShowPlayersAnswersCommand(@Payload CommandMessage<QuestionDTO> message) {
        CommandMessage<Object> response = new CommandMessage<>();

        Map<String, Answer> answerMap = answerService.getAnswersByQuestionGroupedByPlayerName(
                message.getContent().getId()
        );

        Map<String, AnswerDTO> result = new HashMap<>();
        for(Map.Entry<String, Answer> e: answerMap.entrySet()) {
            result.put(e.getKey(), answerDtoConverter.convertEntityToDTO(e.getValue()));
        }

        response.setCommand(message.getCommand());
        response.setContent(result);

        return response;
    }

    @MessageMapping("/app/admin/command")
    @SendTo("/app/client/getCommand")
    public CommandMessage transitCommand(@Payload CommandMessage message) {
        return message;
    }

    private List<QuestionDTO> convertQuestionListToDtoList(List<Question> questions) {
        return questions
                .stream()
                .map(q -> questionDtoConverter.convertEntityToDTO(q))
                .collect(Collectors.toList());
    }
}

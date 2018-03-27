package ru.intodayer.quizproject.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.dto.PlayerDTO;
import ru.intodayer.quizproject.dto.QuestionDTO;
import ru.intodayer.quizproject.dto.converter.DTOConverter;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.Player;
import ru.intodayer.quizproject.model.Question;
import ru.intodayer.quizproject.model.nested.AnswerStatus;
import ru.intodayer.quizproject.service.AnswerService;
import ru.intodayer.quizproject.service.PlayerService;
import ru.intodayer.quizproject.service.QuestionService;
import ru.intodayer.quizproject.ws.message.CommandMessage;
import ru.intodayer.quizproject.ws.message.nested.Command;
import java.util.*;
import java.util.stream.Collectors;


@Controller
public class AdminWebSocketController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    @Qualifier("playerDtoConverter")
    private DTOConverter<Player, PlayerDTO> playerDtoConverter;

    @Autowired
    @Qualifier("questionDtoConverter")
    private DTOConverter<Question, QuestionDTO> questionDtoConverter;

    @Autowired
    @Qualifier("answerDtoConverter")
    private DTOConverter<Answer, AnswerDTO> answerDtoConverter;

    @MessageMapping("/app/admin/command/load")
    @SendTo("/app/client/getCommand")
    public CommandMessage handleLoadCommand(@Payload CommandMessage message) {
        List<List<QuestionDTO>> content = questionService.getAllQuestionGroupedByRound()
                .stream()
                .map(this::convertQuestionListToDtoList)
                .collect(Collectors.toList());

        return createResponse(message.getCommand(), content);
    }

    @MessageMapping("/app/admin/command/show_players_answers")
    @SendTo("/app/client/getCommand")
    public CommandMessage handleShowPlayersAnswersCommand(@Payload CommandMessage<QuestionDTO> message) {
        Map<String, Answer> answerMap = answerService.getAnswersByQuestionGroupedByPlayerName(
                message.getContent().getId()
        );

        Map<String, AnswerDTO> content = new HashMap<>();
        for(Map.Entry<String, Answer> e: answerMap.entrySet()) {
            content.put(e.getKey(), answerDtoConverter.convertEntityToDTO(e.getValue()));
        }

        return createResponse(message.getCommand(), content);
    }

    @MessageMapping("/app/admin/command/calc_players_results")
    @SendTo("/app/client/getCommand")
    public CommandMessage handleCalcPlayersResultsCommand(@Payload CommandMessage message) {
        List<Player> players = playerService.getAllPlayers();

        updatePlayersResults(players);
        playerService.updatePlayers(players);

        List<PlayerDTO> content = players.stream()
                .map(p -> playerDtoConverter.convertEntityToDTO(p))
                .collect(Collectors.toList());

        return createResponse(message.getCommand(), content);
    }

    @MessageMapping("/app/admin/command")
    @SendTo("/app/client/getCommand")
    public CommandMessage transitCommand(@Payload CommandMessage message) {
        return message;
    }

    private CommandMessage<Object> createResponse(Command command, Object content) {
        CommandMessage<Object> response = new CommandMessage<>();
        response.setCommand(command);
        response.setContent(content);
        return response;
    }

    private List<QuestionDTO> convertQuestionListToDtoList(List<Question> questions) {
        return questions
                .stream()
                .map(q -> questionDtoConverter.convertEntityToDTO(q))
                .collect(Collectors.toList());
    }

    private void updatePlayersResults(List<Player> players) {
        for (Player p: players) {
            Integer score = (int) p.getAnswerSet().stream()
                    .filter( a -> a.getStatus() == AnswerStatus.RIGHT)
                    .count();

            p.setScore(score);
        }
    }
}

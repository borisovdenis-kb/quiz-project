package ru.intodayer.quizproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.dto.AnswerExtendedDTO;
import ru.intodayer.quizproject.model.AnswerStatus;
import ru.intodayer.quizproject.service.AnswerService;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(path = "/answers", method = RequestMethod.POST)
    public void addAnswer(@RequestBody AnswerDTO answerDto) {
        answerService.addAnswer(answerDto);
    }

    @RequestMapping(path = "/answers", method = RequestMethod.PUT)
    public void updateAnswers(@RequestBody List<AnswerDTO> answerDtoList) {
        answerService.updateAnswers(answerDtoList);
    }

    @RequestMapping(path = "/answers", method = RequestMethod.GET)
    public Map<String, List<AnswerExtendedDTO>> getAnswersByStatus(@RequestParam AnswerStatus status) {
        return answerService.getAnswersGroupedByPlayerName(status);
    }
}

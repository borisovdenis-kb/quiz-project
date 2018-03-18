package ru.intodayer.quizproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.model.AnswerStatus;
import ru.intodayer.quizproject.service.AnswerService;


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

    @RequestMapping(path = "/answers", method = RequestMethod.GET)
    public void getUnresolvedAnswers(@RequestParam AnswerStatus answerStatus) {

    }

}

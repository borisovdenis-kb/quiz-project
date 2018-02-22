package ru.intodayer.quizproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.intodayer.quizproject.dto.AnswerDto;
import ru.intodayer.quizproject.service.AnswerService;


@RestController
@RequestMapping("/api")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(path = "/answers", method = RequestMethod.POST)
    public void addAnswer(@RequestBody AnswerDto answerDto) {
        answerService.addAnswer(answerDto);
    }

}

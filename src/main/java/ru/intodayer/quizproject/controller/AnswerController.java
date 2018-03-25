package ru.intodayer.quizproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.intodayer.quizproject.dto.AnswerDTO;
import ru.intodayer.quizproject.dto.AnswerExtendedDTO;
import ru.intodayer.quizproject.dto.converter.DTOConverter;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.nested.AnswerStatus;
import ru.intodayer.quizproject.service.AnswerService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    @Qualifier("answerDtoConverter")
    private DTOConverter<Answer, AnswerDTO> answerDtoConverter;

    @Autowired
    @Qualifier("answerExtendedDtoConverter")
    private DTOConverter<Answer, AnswerExtendedDTO> answerExtendedDtoConverter;

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(path = "/answers", method = RequestMethod.POST)
    public void addAnswer(@RequestBody AnswerDTO answerDto) {
        answerService.addAnswer(answerDtoConverter.convertDTOToEntity(answerDto));
    }

    @RequestMapping(path = "/answers", method = RequestMethod.PUT)
    public void updateAnswers(@RequestBody List<AnswerDTO> answerDtoList) {
        answerService.updateAnswers(
                answerDtoList.stream()
                        .map( dto -> answerDtoConverter.convertDTOToEntity(dto))
                        .collect(Collectors.toList())
        );
    }

    @RequestMapping(path = "/answers", method = RequestMethod.GET)
    public Map<String, List<AnswerExtendedDTO>> getAnswersByStatus(@RequestParam AnswerStatus status) {
        Map<String, List<AnswerExtendedDTO>> result = new HashMap<>();
        Map<String, List<Answer>> answerMap = answerService.getAnswersByStatusGroupedByPlayerName(status);

        for(Map.Entry<String, List<Answer>> e: answerMap.entrySet()) {
            result.put(e.getKey(), this.convertAnswerListToExtendedDtoList(e.getValue()));
        }

        return result;
    }

    private List<AnswerExtendedDTO> convertAnswerListToExtendedDtoList(List<Answer> answerList) {
        return answerList.stream()
                .map( a -> answerExtendedDtoConverter.convertEntityToDTO(a))
                .collect(Collectors.toList());
    }
}

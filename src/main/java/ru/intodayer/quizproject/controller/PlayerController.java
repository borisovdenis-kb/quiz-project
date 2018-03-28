package ru.intodayer.quizproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.intodayer.quizproject.dto.PlayerDTO;
import ru.intodayer.quizproject.dto.converter.DTOConverter;
import ru.intodayer.quizproject.model.Player;
import ru.intodayer.quizproject.service.PlayerService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    @Qualifier("playerDtoConverter")
    private DTOConverter<Player, PlayerDTO> dtoConverter;

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(path = "/players", method = RequestMethod.POST)
    public Long addPlayer(@RequestBody PlayerDTO playerDto) {
        return playerService.addPlayer(dtoConverter.convertDTOToEntity(playerDto));
    }

}

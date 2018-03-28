package ru.intodayer.quizproject.dto.converter;

import org.springframework.stereotype.Component;
import ru.intodayer.quizproject.dto.PlayerDTO;
import ru.intodayer.quizproject.model.Player;

@Component("playerDtoConverter")
public class PlayerDTOConverter implements DTOConverter<Player, PlayerDTO> {

    @Override
    public Player convertDTOToEntity(PlayerDTO dto) {
        Player player = new Player();
        player.setId(dto.getId());
        player.setName(dto.getName());
        player.setScore(dto.getScore());
        return player;
    }

    @Override
    public PlayerDTO convertEntityToDTO(Player entity) {
        PlayerDTO playerDto = new PlayerDTO();
        playerDto.setId(entity.getId());
        playerDto.setName(entity.getName());
        playerDto.setScore(entity.getScore());
        return playerDto;
    }
}

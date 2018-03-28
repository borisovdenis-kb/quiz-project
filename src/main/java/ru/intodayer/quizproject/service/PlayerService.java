package ru.intodayer.quizproject.service;

import ru.intodayer.quizproject.model.Player;
import java.util.List;


public interface PlayerService {

    Long addPlayer(Player player);

    List<Player> getAllPlayers();

    void updatePlayers(List<Player> players);

}

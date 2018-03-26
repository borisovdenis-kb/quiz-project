package ru.intodayer.quizproject.service;

import ru.intodayer.quizproject.model.Player;
import java.util.List;


public interface PlayerService {

    List<Player> getAllPlayers();

    void updatePlayers(List<Player> players);

}

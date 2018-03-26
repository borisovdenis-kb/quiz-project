package ru.intodayer.quizproject.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.intodayer.quizproject.model.Player;
import ru.intodayer.quizproject.repository.PlayerRepository;
import ru.intodayer.quizproject.service.PlayerService;
import java.util.List;


@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void updatePlayers(List<Player> players) {
        playerRepository.save(players);
    }
}

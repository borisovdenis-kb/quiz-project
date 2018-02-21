package ru.intodayer.quizproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.intodayer.quizproject.model.Player;


public interface PlayerRepository extends JpaRepository<Player, Long> {
}

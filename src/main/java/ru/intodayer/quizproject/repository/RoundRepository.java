package ru.intodayer.quizproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.intodayer.quizproject.model.Round;


public interface RoundRepository extends JpaRepository<Round, Long> {
}

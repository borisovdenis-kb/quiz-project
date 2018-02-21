package ru.intodayer.quizproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.intodayer.quizproject.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}

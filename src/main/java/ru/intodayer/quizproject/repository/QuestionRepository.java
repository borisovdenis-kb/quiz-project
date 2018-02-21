package ru.intodayer.quizproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.intodayer.quizproject.model.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}

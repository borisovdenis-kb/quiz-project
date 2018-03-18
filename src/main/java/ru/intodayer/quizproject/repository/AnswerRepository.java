package ru.intodayer.quizproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.intodayer.quizproject.model.Answer;
import ru.intodayer.quizproject.model.AnswerStatus;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAllByAnswerStatus(AnswerStatus answerStatus);

}

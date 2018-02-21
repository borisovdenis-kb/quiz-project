package ru.intodayer.quizproject.service.Implementation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.intodayer.quizproject.QuizProjectApplication;
import ru.intodayer.quizproject.service.QuestionService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = QuizProjectApplication.class)
public class QuestionServiceImplTest {

    @Autowired
    private QuestionService questionService;

    @Test
    public void getAllQuestions() {
        System.out.println("\n" + questionService.getAllQuestions() + "\n");
    }
}
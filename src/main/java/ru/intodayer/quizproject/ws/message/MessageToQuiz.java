package ru.intodayer.quizproject.ws.message;

import ru.intodayer.quizproject.dto.QuestionDTO;
import java.util.List;


public class MessageToQuiz {
    private Command command;
    private List<List<QuestionDTO>> questions;

    public MessageToQuiz() {}

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public List<List<QuestionDTO>> getQuestions() {
        return questions;
    }

    public void setQuestions(List<List<QuestionDTO>> questions) {
        this.questions = questions;
    }
}

package ru.intodayer.quizproject.ws.message;

import ru.intodayer.quizproject.dto.QuestionDto;
import java.util.List;


public class MessageToQuiz {
    private Command command;
    private List<List<QuestionDto>> questions;

    public MessageToQuiz() {}

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public List<List<QuestionDto>> getQuestions() {
        return questions;
    }

    public void setQuestions(List<List<QuestionDto>> questions) {
        this.questions = questions;
    }
}

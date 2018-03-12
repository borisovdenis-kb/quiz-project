package ru.intodayer.quizproject.ws.message;

import ru.intodayer.quizproject.dto.QuestionDto;
import java.util.List;


public class Message {
    private Command command;
    private List<QuestionDto> questionList;

    public Message() {}

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public List<QuestionDto> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionDto> questionList) {
        this.questionList = questionList;
    }
}

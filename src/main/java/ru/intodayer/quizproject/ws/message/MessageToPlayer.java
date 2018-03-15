package ru.intodayer.quizproject.ws.message;

import ru.intodayer.quizproject.dto.QuestionDto;

public class MessageToPlayer {
    private QuestionDto question;

    public MessageToPlayer() {}

    public QuestionDto getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDto question) {
        this.question = question;
    }
}

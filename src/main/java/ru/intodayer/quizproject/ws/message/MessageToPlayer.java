package ru.intodayer.quizproject.ws.message;

import ru.intodayer.quizproject.dto.QuestionDTO;

public class MessageToPlayer {
    private QuestionDTO question;

    public MessageToPlayer() {}

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }
}

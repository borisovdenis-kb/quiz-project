package ru.intodayer.quizproject.dto;

import ru.intodayer.quizproject.model.AnswerStatus;

public class AnswerDTO {
    private Long id;
    private Long playerId;
    private Long questionId;
    private String answer;
    private AnswerStatus status;

    public AnswerDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public AnswerStatus getStatus() {
        return status;
    }

    public void setStatus(AnswerStatus status) {
        this.status = status;
    }
}

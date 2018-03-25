package ru.intodayer.quizproject.dto;

import ru.intodayer.quizproject.model.nested.AnswerStatus;


public class AnswerExtendedDTO {
    private Long id;
    private QuestionDTO question;
    private String answer;
    private String rightAnswer;
    private PlayerDTO player;
    private AnswerStatus status;

    public AnswerExtendedDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }

    public AnswerStatus getStatus() {
        return status;
    }

    public void setStatus(AnswerStatus status) {
        this.status = status;
    }
}

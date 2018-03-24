package ru.intodayer.quizproject.dto;

public class QuestionDTO {
    private Long id;
    private String question;
    private String rightAnswer;
    private String roundName;
    private Integer timeNeededSec;
    private String imageFilePath;
    private String soundFilePath;
    private String funnyStuffFilePath;

    public QuestionDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public Integer getTimeNeededSec() {
        return timeNeededSec;
    }

    public void setTimeNeededSec(Integer timeNeededSec) {
        this.timeNeededSec = timeNeededSec;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public String getSoundFilePath() {
        return soundFilePath;
    }

    public void setSoundFilePath(String soundFilePath) {
        this.soundFilePath = soundFilePath;
    }

    public String getFunnyStuffFilePath() {
        return funnyStuffFilePath;
    }

    public void setFunnyStuffFilePath(String funnyStuffFilePath) {
        this.funnyStuffFilePath = funnyStuffFilePath;
    }
}

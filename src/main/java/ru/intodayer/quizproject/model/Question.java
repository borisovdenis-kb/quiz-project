package ru.intodayer.quizproject.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "question")
    private String question;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round round;

    @Column(name = "time_needed_sec")
    private Integer timeNeededSec;

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Answer> answerSet;

    @Column(name = "image")
    private String imageFilePath;

    @Column(name = "sound")
    private String soundFilePath;

    public Question() {}

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Integer getTimeNeededSec() {
        return timeNeededSec;
    }

    public void setTimeNeededSec(Integer timeNeededSec) {
        this.timeNeededSec = timeNeededSec;
    }

    public Set<Answer> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<Answer> answerSet) {
        this.answerSet = answerSet;
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

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", round=" + round +
                ", imageFilePath='" + imageFilePath + '\'' +
                ", soundFilePath='" + soundFilePath + '\'' +
                '}';
    }
}

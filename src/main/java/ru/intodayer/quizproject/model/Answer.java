package ru.intodayer.quizproject.model;

import javax.persistence.*;


@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "answer_status")
    private AnswerStatus answerStatus;

    public Answer() {}

    public Long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public AnswerStatus getAnswerStatus() {
        return answerStatus;
    }

    public void setAnswerStatus(AnswerStatus answerStatus) {
        this.answerStatus = answerStatus;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "player=" + player +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                ", answerStatus=" + answerStatus +
                '}';
    }
}
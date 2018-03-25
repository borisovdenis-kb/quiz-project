package ru.intodayer.quizproject.model;

import ru.intodayer.quizproject.model.nested.AnswerStatus;

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

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AnswerStatus status;

    public Answer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AnswerStatus getStatus() {
        return status;
    }

    public void setStatus(AnswerStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", player=" + player +
                ", answer='" + answer + '\'' +
                ", status=" + status +
                '}';
    }
}
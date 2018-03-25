package ru.intodayer.quizproject.model;

import ru.intodayer.quizproject.model.nested.RoundType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "round")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RoundType type;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "round", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Question> questionSet;

    public Round() {}

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoundType getType() {
        return type;
    }

    public void setType(RoundType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }

    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", questionSet=" + questionSet +
                '}';
    }
}

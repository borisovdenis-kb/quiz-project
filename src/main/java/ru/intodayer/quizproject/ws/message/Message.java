package ru.intodayer.quizproject.ws.message;


public class Message<T> {
    private T content;

    public Message() {}

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

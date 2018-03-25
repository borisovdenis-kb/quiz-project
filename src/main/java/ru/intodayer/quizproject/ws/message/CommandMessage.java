package ru.intodayer.quizproject.ws.message;

import ru.intodayer.quizproject.ws.message.nested.Command;


public class CommandMessage<T> {
    private Command command;
    private T content;

    public CommandMessage() {}

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

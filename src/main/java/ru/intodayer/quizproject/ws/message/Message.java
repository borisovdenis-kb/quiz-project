package ru.intodayer.quizproject.ws.message;


public class Message {
    private Command command;
    private Object content;

    public Message() {}

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}

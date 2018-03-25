package ru.intodayer.quizproject.ws.message.nested;

public class Command {
    private CommandName name;
    private Object metaInfo;

    public Command() {}

    public CommandName getName() {
        return name;
    }

    public void setName(CommandName name) {
        this.name = name;
    }

    public Object getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(Object metaInfo) {
        this.metaInfo = metaInfo;
    }
}

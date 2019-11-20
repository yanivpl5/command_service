package com.ruckus.command_service.domain;

public class CommandExecRequest {
    private String id;
    private String command;
    private int frequency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "CommandExecRequest{" +
                "id='" + id + '\'' +
                ", command='" + command + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}

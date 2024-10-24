package org.example.behavioral.memento.begin.command;

public interface WorkflowCommand {

    void execute();

    void undo();
}

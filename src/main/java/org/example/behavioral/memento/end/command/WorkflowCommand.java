package org.example.behavioral.memento.end.command;

public interface WorkflowCommand {

    void execute();

    void undo();
}

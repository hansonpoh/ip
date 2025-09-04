package command;

import amogus.AmogusException;
import amogus.FileStorage;
import amogus.UI;
import tasks.TaskList;

public interface Command {

    String execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException;
    boolean isExit();
}

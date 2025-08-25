package Command;

import Amogus.AmogusException;
import Amogus.FileStorage;
import Amogus.UI;
import Tasks.TaskList;

public interface Command {

    void execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException;
    boolean isExit();
}

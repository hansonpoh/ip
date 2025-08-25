package Command;

import Amogus.FileStorage;
import Amogus.UI;
import Tasks.TaskList;

public class MarkCommand implements Command {

    private int idx;

    public MarkCommand(int idx) {
        this.idx = idx;
    }

    /**
     * Marks the task as done.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     */
    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) {
        tasks.mark(idx);
        ui.showMsg(ui.format("Nice! I've marked this task as done:\n  " + tasks.taskDesc(idx) + "\n"));
        f.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

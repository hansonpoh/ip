package command;

import amogus.FileStorage;
import amogus.UI;
import tasks.TaskList;

/**
 * Representing marking a task as complete.
 */
public class MarkCommand implements Command {

    private int idx;

    public MarkCommand(int idx) {
        this.idx = idx;
        assert idx >= 0 : "index cannot be negative";
    }

    /**
     * Marks the task as done.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     */
    @Override
    public String execute(TaskList tasks, UI ui, FileStorage f) {
        String msg = "Nice! I've marked this task as done:\n  " + tasks.getTaskDesc(idx) + "\n";
        tasks.mark(idx);
        ui.showMsg(ui.format(msg));
        f.saveTasks(tasks);
        return msg;
    }

    /**
     * For the program to know when to exit the conversation with user.
     * @return boolean
     */
    @Override
    public boolean isExit() {
        return false;
    }

}

package command;

import amogus.FileStorage;
import amogus.UI;
import tasks.TaskList;

/**
 * Represents marking a Task as incomplete.
 */
public class UnmarkCommand implements Command {

    private int idx;

    /**
     * Creates the unmark command to unmark a given task
     * @param idx index of task in the task list.
     */
    public UnmarkCommand(int idx) {
        this.idx = idx;
        assert idx >= 0 : "index cannot be negative";
    }

    /**
     * Marks the task as not done.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     */
    @Override
    public String execute(TaskList tasks, UI ui, FileStorage f) {
        tasks.unmark(idx);
        String msg = "OK, I've marked this task as not done yet:\n  " + tasks.getTaskDesc(idx) + "\n";
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

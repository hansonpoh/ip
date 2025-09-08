package command;

import amogus.FileStorage;
import amogus.UI;
import tasks.TaskList;

/**
 * Represents marking a Task as incomplete.
 */
public class UnmarkCommand implements Command {

    private int idx;

    public UnmarkCommand(int idx) {
        this.idx = idx;
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
        String msg = "OK, I've marked this task as not done yet:\n  " + tasks.getTaskDesc(idx) + "\n";
        tasks.unmark(idx);
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

    public String getResponse(String input) {
        return input;
    }
}

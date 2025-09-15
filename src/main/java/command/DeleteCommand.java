package command;

import amogus.FileStorage;
import amogus.UI;
import tasks.TaskList;

/**
 * Represents deleting a Task from the list.
 */
public class DeleteCommand implements Command {

    private int idx;

    /**
     * Creates the delete command for deleting a task from list
     * @param idx index of task in the list
     */
    public DeleteCommand(int idx) {
        this.idx = idx;
        assert idx >= 0 : "index cannot be negative";
    }

    /**
     * Removes the specified task using its index.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     */
    @Override
    public String execute(TaskList tasks, UI ui, FileStorage f) {
        String msg = "Noted. I've removed this task:\n  " + tasks.get(idx).getDisplayString() + "\n";
        ui.showMsg(ui.format(msg));
        tasks.delete(idx);
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

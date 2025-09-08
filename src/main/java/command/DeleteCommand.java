package command;

import amogus.FileStorage;
import amogus.UI;
import tasks.TaskList;

/**
 * Represents deleting a Task from the list.
 */
public class DeleteCommand implements Command {

    private int idx;

    public DeleteCommand(int idx) {
        this.idx = idx;
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
        String msg = "Noted. I've removed this task:\n  " + tasks.getTaskDesc(idx) + "\n";
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

    public String getResponse(String input) {
        return input;
    }
}

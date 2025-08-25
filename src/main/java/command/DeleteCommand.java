package command;

import amogus.FileStorage;
import amogus.UI;
import tasks.TaskList;

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
    public void execute(TaskList tasks, UI ui, FileStorage f) {
        ui.showMsg(ui.format("Noted. I've removed this task:\n  " + tasks.taskDesc(idx) + "\n"));
        tasks.delete(idx);
        f.saveTasks(tasks);
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

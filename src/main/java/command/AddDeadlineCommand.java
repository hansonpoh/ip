package command;

import amogus.AmogusException;
import amogus.FileStorage;
import amogus.UI;
import tasks.Deadlines;
import tasks.TaskList;

/**
 * This class creates a Deadlines object to be added
 * to the list of tasks.
 */
public class AddDeadlineCommand implements Command {

    private String desc;

    public AddDeadlineCommand(String desc) throws AmogusException {
        this.desc = desc;
    }

    /**
     * Creates the Tasks.Deadlines object to be added into the list of tasks.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     * @throws AmogusException insufficient information to create the task
     */
    @Override
    public String execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException {
        String[] parts = desc.split("/by");
        String descr = parts[0].trim();
        String by = parts[1].trim();
        Deadlines deadlines = new Deadlines(descr, by);

        String msg = "Got it. I've added this task:\n  " + deadlines.toString() + "\nNow you have "
                + tasks.getSize() + " tasks in the list.\n";
        tasks.add(deadlines);
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

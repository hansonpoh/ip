package command;

import amogus.AmogusException;
import amogus.FileStorage;
import amogus.UI;
import tasks.TaskList;
import tasks.ToDo;

public class AddToDoCommand implements Command {

    private String desc;

    public AddToDoCommand(String desc) throws AmogusException {
        this.desc = desc;
    }

    /**
     * Creates the Tasks.ToDo object to be added into the list of tasks.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     * @throws AmogusException insufficient information to create the task
     */
    @Override
    public String execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException {
        ToDo todo = new ToDo(desc);
        tasks.add(todo);

        String msg = "Got it. I've added this task:\n  " + todo + "\nNow you have " + tasks.size() + " tasks in the list.";
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

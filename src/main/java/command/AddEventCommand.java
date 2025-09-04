package command;

import amogus.AmogusException;
import amogus.FileStorage;
import amogus.UI;
import tasks.Event;
import tasks.TaskList;

public class AddEventCommand implements Command {

    private String desc;

    public AddEventCommand(String desc) throws AmogusException {
        this.desc = desc;
    }

    /**
     * Creates the Tasks.Event object to be added into the list of tasks.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     * @throws AmogusException insufficient information to create the task
     */
    @Override
    public String execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException {
        String[] parts = desc.split("/from|/to");
        String descr = parts[0].trim();
        String start = parts[1].trim();
        String end = parts[2].trim();
        Event event = new Event(descr, start, end);

        String msg = "Got it. I've added this task:\n  " + event.toString() + "\nNow you have " + tasks.size() + " tasks in the list.\n";
        tasks.add(event);
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

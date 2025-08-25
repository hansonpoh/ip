public class AddToDoCommand implements Command {

    private String desc;

    public AddToDoCommand(String desc) throws AmogusException {
        this.desc = desc;
    }

    /**
     * Creates the ToDo object to be added into the list of tasks.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     * @throws AmogusException insufficient information to create the task
     */
    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException {
        ToDo todo = new ToDo(desc);
        tasks.add(todo);
        ui.showMsg(ui.format("Got it. I've added this task:\n  " + todo.toString() + "\nNow you have " + tasks.size() + " tasks in the list."));
        f.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

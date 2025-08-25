public class AddDeadlineCommand implements Command {

    private String desc;

    public AddDeadlineCommand(String desc) throws AmogusException {
        this.desc = desc;
    }

    /**
     * Creates the Deadlines object to be added into the list of tasks.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     * @throws AmogusException insufficient information to create the task
     */
    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException {
        String[] parts = desc.split("/by");
        String descr = parts[0].trim();
        String by = parts[1].trim();
        Deadlines deadlines = new Deadlines(descr, by);

        tasks.add(deadlines);
        ui.showMsg(ui.format("Got it. I've added this task:\n  " + deadlines.toString() + "\nNow you have " + tasks.size() + " tasks in the list.\n"));
        f.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

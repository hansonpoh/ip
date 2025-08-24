public class AddDeadlineCommand implements Command {

    private String desc;

    public AddDeadlineCommand(String desc) throws AmogusException {
        this.desc = desc;
    }

    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException {
        String[] parts = desc.split("/by");
        String descr = parts[0].trim();
        String by = parts[1].trim();
        Deadlines deadlines = new Deadlines(descr, by);

        tasks.add(deadlines);
        ui.showMsg(ui.format("Got it. I've added this task:\n  " + deadlines.fullDesc() + "\nNow you have " + tasks.size() + " tasks in the list."));
        f.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

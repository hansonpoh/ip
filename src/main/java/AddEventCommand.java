public class AddEventCommand implements Command {

    private String desc;

    public AddEventCommand(String desc) throws AmogusException {
        this.desc = desc;
    }

    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException {
        String[] parts = desc.split("/from|/to");
        String descr = parts[0].trim();
        String start = parts[1].trim();
        String end = parts[2].trim();
        Event event = new Event(descr, start, end);

        tasks.add(event);
        ui.showMsg(ui.format("Got it. I've added this task:\n  " + event.fullDesc() + "\nNow you have " + tasks.size() + " tasks in the list.\n"));
        f.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

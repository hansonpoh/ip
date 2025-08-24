public class AddToDoCommand implements Command {

    private String desc;

    public AddToDoCommand(String desc) throws AmogusException {
        this.desc = desc;
    }

    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException {
        ToDo todo = new ToDo(desc);
        tasks.add(todo);
        ui.showMsg(ui.format("Got it. I've added this task:\n  " + todo.fullDesc() + "\nNow you have " + tasks.size() + " tasks in the list."));
        f.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

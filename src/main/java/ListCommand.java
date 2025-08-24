public class ListCommand implements Command {

    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) {
        if (tasks.isEmpty()) {
            ui.showMsg(ui.format("Empty List.\n"));
        } else {
            ui.showTaskList(tasks);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

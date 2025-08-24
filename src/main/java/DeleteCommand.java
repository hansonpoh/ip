public class DeleteCommand implements Command {

    private int idx;

    public DeleteCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) {
        ui.showMsg(ui.format("Noted. I've removed this task:\n  " + tasks.taskDesc(idx) + "\n"));
        tasks.delete(idx);
        f.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

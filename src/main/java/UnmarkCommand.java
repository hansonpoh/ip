public class UnmarkCommand implements Command {

    private int idx;

    public UnmarkCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) {
        tasks.unmark(idx);
        ui.showMsg(ui.format("OK, I've marked this task as not done yet:\n  " + tasks.taskDesc(idx) + "\n"));
        f.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

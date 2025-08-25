public class ListCommand implements Command {

    /**
     * Reads from any existing txt file and lists its contents.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     */
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

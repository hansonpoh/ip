public class ExitCommand implements Command {

    /**
     * Ends the chat function and exits program.
     *
     * @param tasks List of tasks
     * @param ui any display back to the user
     * @param f existing txt file
     */
    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) {
        ui.exit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}

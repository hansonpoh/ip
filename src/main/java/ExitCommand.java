public class ExitCommand implements Command {

    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) {
        ui.exit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}

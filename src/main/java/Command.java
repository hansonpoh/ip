public interface Command {

    void execute(TaskList tasks, UI ui, FileStorage f) throws AmogusException;
    boolean isExit();
}

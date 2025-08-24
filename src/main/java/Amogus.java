import java.io.IOException;

public class Amogus {

    static final String name = "Amogus";
    private static final String path = "./data/TaskList.txt";

    /**
     * Creates all necessary objects for interaction between each other,
     * namely UI for responses to user, FileStorage for hard disk load
     * and store, TaskList for list of tasks.
     */
    public static void Chat() {
        UI ui = new UI();
        ui.welcome();
        FileStorage fs = new FileStorage(path);
        TaskList tasks;

        try {
            tasks = fs.loadTasks();
        } catch (AmogusException | IOException e) {
            ui.showMsg(e.getMessage());
            tasks = new TaskList();
        }

        while (true) {
            String input = ui.readCommand();
            try {
                Command command = Parser.parse(input);
                command.execute(tasks, ui, fs);
                if (command.isExit()) {
                    break;
                }
            } catch (AmogusException e) {
                ui.showMsg(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Chat();
    }
}

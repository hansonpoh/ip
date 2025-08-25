package amogus;

import command.Command;
import tasks.TaskList;

import java.io.IOException;

public class Amogus {

    static final String NAME = "amogus";
    private static final String path = "./data/Tasks.TaskList.txt";

    /**
     * Creates all necessary objects for interaction between each other,
     * namely Amogus.UI for responses to user, Amogus.FileStorage for hard disk load
     * and store, Tasks.TaskList for list of tasks.
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

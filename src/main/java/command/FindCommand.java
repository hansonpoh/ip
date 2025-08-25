package command;

import amogus.FileStorage;
import amogus.UI;
import tasks.Task;
import tasks.TaskList;

public class FindCommand implements Command {

    private String wordToFind;

    public FindCommand(String word) {
        this.wordToFind = word;
    }

    @Override
    public void execute(TaskList tasks, UI ui, FileStorage f) {
        TaskList tasksWithWord = new TaskList();

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.toString().toLowerCase().contains(wordToFind.toLowerCase())) {
                tasksWithWord.add(task);
            }
        }

        if (tasksWithWord.isEmpty()) {
            ui.showMsg("Empty List. \n");
        } else {
            ui.showTaskList(tasksWithWord);
        }
    }

    /**
     * For the program to know when to exit the conversation with user.
     * @return boolean
     */
    @Override
    public boolean isExit() {
        return false;
    }
}

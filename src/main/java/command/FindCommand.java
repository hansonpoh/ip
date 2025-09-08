package command;

import amogus.FileStorage;
import amogus.UI;
import tasks.Task;
import tasks.TaskList;

/**
 * Represents finding a task through an input keyword.
 */
public class FindCommand implements Command {

    private String wordToFind;

    public FindCommand(String word) {
        this.wordToFind = word;
        assert word != null : "unable to search for empty word";
    }

    @Override
    public String execute(TaskList tasks, UI ui, FileStorage f) {
        TaskList tasksWithWord = new TaskList();

        for (int i = 0; i < tasks.getSize(); i++) {
            Task task = tasks.get(i);
            if (task.toString().toLowerCase().contains(wordToFind.toLowerCase())) {
                tasksWithWord.add(task);
            }
        }

        if (tasksWithWord.isEmpty()) {
            return ui.showMsg("Empty List. \n");
        } else {
            return ui.showTaskList(tasksWithWord);
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

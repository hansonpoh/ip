package amogus;

import tasks.TaskList;

import java.util.Scanner;

public class UI {

    static String HORILINES = "____________________________________________________________\n";
    static String INTRO = "Hello! I'm " + Amogus.NAME + "!\nWhat can I do for you?\n";
    static String OUTRO = "Bye. Hope to see you again soon!\n";

    public void showMsg(String msg) {
        System.out.println(msg);
    }

    public String format(String msg) {
        return HORILINES + msg + HORILINES;
    }

    /**
     * Iterates through the list of tasks, then prints them out
     * in the appropriate format
     *
     * @param tasks list of tasks
     */
    public void showTaskList(TaskList tasks) {
        String msg = "Here are the tasks in your list:\n";
        for (int i = 0; i < tasks.size(); i++) {
            int j = i + 1;
            msg += j + ". " + tasks.taskDesc(i) + "\n";
        }
        System.out.println(format(msg));
    }

    /**
     * Takes in user input for command
     *
     * @return full line of user input to be parsed
     */
    public String readCommand() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    /**
     * Prints welcome message.
     */
    public void welcome() {
        System.out.println(format(INTRO));
    }

    /**
     * Prints exit message.
     */
    public void exit() {
        System.out.println(format(OUTRO));
    }
}

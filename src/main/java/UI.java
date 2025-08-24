import java.util.Scanner;

public class UI {

    static String horiLines = "____________________________________________________________\n";
    static String intro = "Hello! I'm " + Amogus.name + "!\nWhat can I do for you?\n";
    static String outro = "Bye. Hope to see you again soon!\n";

    public void showMsg(String msg) {
        System.out.println(msg);
    }

    public String format(String msg) {
        return horiLines + msg + horiLines;
    }

    /**
     * Iterates through the list of tasks, then prints them out
     * in the appropriate format
     *
     * @param tasks
     */
    public void showTaskList(TaskList tasks) {
        String msg = "Here are the tasks in your list:\n";
        for (int i = 0; i < tasks.size(); i++) {
            int j = i + 1;
            msg += j + ". " + tasks.taskDesc(i) + "\n";
        }
        System.out.println(format(msg));
    }

    public String readCommand() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public void welcome() {
        System.out.println(format(intro));
    }

    public void exit() {
        System.out.println(format(outro));
    }
}

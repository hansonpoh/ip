import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Amogus {

    static final String name = "Amogus";
    static String horiLines = "____________________________________________________________\n";
    static String intro = "Hello! I'm " + Amogus.name + "!\nWhat can I do for you?\n";
    static String outro = "Bye. Hope to see you again soon!\n";
    static final String welcome = horiLines + intro + horiLines;
    static final String end = horiLines + outro + horiLines;

    static ArrayList<Task> list = new ArrayList<Task>();

    /**
     * Sends out a welcome message before waiting for the users
     * input for various modes of activity, either listing, marking,
     * or unmarking different types of tasks.
     */
    public static void Chat() {
        System.out.println(welcome);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int idx = 0;
        try {
            while (true) {
                if (Objects.equals(input, "bye")) {
                    System.out.println(end);
                    break;
                } else if (Objects.equals(input, "list")) {
                    if (list.isEmpty()) {
                        System.out.println(horiLines + "Empty List." + "\n" + horiLines);
                    } else {
                        String msg = "Here are the tasks in your list:\n";
                        for (int i = 0; i < idx; i++) {
                            int j = i + 1;
                            msg += j + "." + list.get(i).fullDesc() + "\n";
                        }
                        System.out.println(horiLines + msg + horiLines);
                    }
                } else if (Objects.equals(input, "mark")) {
                    int idxMark = scanner.nextInt();
                    list.get(idxMark - 1).mark();
                    String msg = horiLines + "Nice! I've marked this task as done:\n" + "  " + list.get(idxMark - 1).fullDesc() + "\n" + horiLines;
                    System.out.println(msg);
                } else if (Objects.equals(input, "unmark")) {
                    int idxMark = scanner.nextInt();
                    list.get(idxMark - 1).unmark();
                    String msg = horiLines + "OK, I've marked this task as not done yet:\n" + "  " + list.get(idxMark - 1).fullDesc() + "\n" + horiLines;
                    System.out.println(msg);
                } else if (Objects.equals(input, "delete")) {
                    int idxDel = scanner.nextInt();
                    System.out.println(horiLines + "Noted. I've removed this task:\n  " + list.get(idxDel - 1).fullDesc() + "\nNow you have " + (idx-1) + " tasks in the list.");
                    list.remove(idxDel - 1);
                    idx--;
                } else {
                    String desc = scanner.nextLine();
                    if (Objects.equals(input, "todo")) {
                        list.add(new ToDo(desc.trim()));
                    } else if (Objects.equals(input, "deadline")) {
                        String[] parts = desc.split("/by");
                        String descr = parts[0].trim();
                        String by = parts[1].trim();
                        list.add(new Deadlines(descr, by));
                    } else if (Objects.equals(input, "event")) {
                        String[] parts = desc.split("/from|/to");
                        String descr = parts[0].trim();
                        String start = parts[1].trim();
                        String end = parts[2].trim();
                        list.add(new Event(descr, start, end));
                    } else {
                        throw new AmogusException("I'm not sure what type of task this is! Please try again!");
                    }
                    System.out.println(horiLines + "Got it. I've added this task: \n  " + list.get(idx).fullDesc() + "\nNow you have " + (idx + 1) + " tasks in the list.\n" + horiLines);
                    idx++;
                }

                input = scanner.next();
            }
        } catch (AmogusException e) {
            System.out.println(horiLines + e.getMessage() + "\n" + horiLines);
        }
    }

    public static void main(String[] args) {
        Chat();
    }
}

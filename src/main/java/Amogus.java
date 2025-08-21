import java.util.Objects;
import java.util.Scanner;

public class Amogus {

    static final String name = "Amogus";
    static String horiLines = "____________________________________________________________\n";
    static String intro = "Hello! I'm " + Amogus.name + "!\nWhat can I do for you?\n";
    static String outro = "Bye. Hope to see you again soon!\n";
    static final String welcome = horiLines + intro + horiLines;
    static final String end = horiLines + outro + horiLines;

    static Task[] list = new Task[100];

    /**
     * Sends out a welcome message before waiting for the users
     * input for various modes of activity, either listing, marking,
     * or unmarking tasks.
     */
    public static void Chat() {
        System.out.println(welcome);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int idx = 0;
        while (true) {
            if (Objects.equals(input, "bye")) {
                System.out.println(end);
                break;
            } else if (Objects.equals(input, "list")) {
                if (list[0] == null) {
                    System.out.println(horiLines + "Empty List." + "\n" + horiLines);
                } else {
                    String msg = "";
                    for (int i = 0; i < idx; i++) {
                        int j = i + 1;
                        msg += j + "." + list[i].fullDesc() + "\n";
                    }
                    System.out.println(horiLines + msg + horiLines);
                }
            } else if (Objects.equals(input, "mark")) {
                int idxMark = scanner.nextInt();
                list[idxMark - 1].mark();
                String msg = horiLines + "Nice! I've marked this task as done:\n" + "  " + list[idxMark - 1].fullDesc() + "\n" + horiLines;
                System.out.println(msg);
            } else if (Objects.equals(input, "unmark")) {
                int idxMark = scanner.nextInt();
                list[idxMark - 1].unmark();
                String msg = horiLines + "OK, I've marked this task as not done yet:\n" + "  " + list[idxMark - 1].fullDesc() + "\n" + horiLines;
                System.out.println(msg);
            } else {
                list[idx] = new Task(input);
                System.out.println(horiLines + "added: " + input + "\n" + horiLines);
                idx++;
            }

            input = scanner.next();
        }
    }

    public static void main(String[] args) {
        Chat();
    }
}

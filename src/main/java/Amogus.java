import java.util.Objects;
import java.util.Scanner;

public class Amogus {

    static final String name = "Amogus";
    static String horiLines = "____________________________________________________________\n";
    static String intro = "Hello! I'm " + Amogus.name + "!\nWhat can I do for you?\n";
    static String outro = "Bye. Hope to see you again soon!\n";
    static final String welcome = horiLines + intro + horiLines;
    static final String end = horiLines + outro + horiLines;

    static String[] list = new String[100];

    /**
     * Sends out a welcome message before waiting for the users
     * input to either add to a list, list the list, or end
     * the conversation
     */
    public static void Chat() {
        System.out.println(welcome);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
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
                        msg += j + ". " + list[i] + "\n";
                    }
                    System.out.println(horiLines + msg + horiLines);
                }
            } else {
                list[idx] = input;
                System.out.println(horiLines + "added: " + input + "\n" + horiLines);
                idx++;
            }

            input = scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        Chat();
    }
}

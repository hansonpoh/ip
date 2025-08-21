import java.util.Objects;
import java.util.Scanner;

public class Amogus {

    static final String name = "Amogus";
    static String horiLines = "____________________________________________________________\n";
    static String intro = "Hello! I'm " + Amogus.name + "!\nWhat can I do for you?\n";
    static String outro = "Bye. Hope to see you again soon!\n";
    static final String defaultMsg = horiLines + intro + horiLines;

    /**
     * Sends out a welcome message before waiting for the users
     * input to echo, unless the input is bye which ends the conversation.
     */
    public static void Echo() {
        System.out.println(defaultMsg);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!Objects.equals(input, "bye")) {
            System.out.println(horiLines + input + "\n" + horiLines);
            input = scanner.nextLine();
        }

        System.out.println(horiLines + outro + horiLines);
    }

    public static void main(String[] args) {
        Echo();
    }
}

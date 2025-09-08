package amogus;

import command.Command;
import command.AddDeadlineCommand;
import command.AddEventCommand;
import command.AddToDoCommand;
import command.DeleteCommand;
import command.ExitCommand;
import command.FindCommand;
import command.ListCommand;
import command.MarkCommand;
import command.UnmarkCommand;

public class Parser {

    /**
     * Takes in user input to be parsed into relevant subclasses
     * of Command.Command to be further executed in their own classes.
     *
     * @param input user input
     * @return Correct sub-Command.Command class to be executed
     * @throws AmogusException unknown command
     */
    public static Command parse(String input) throws AmogusException {
        assert input != null : "input must not be null";

        String[] parts = input.split(" ", 2);
        String commandWord = parts[0];
        String args = parts.length > 1 ? parts[1] : "";

        switch (commandWord.toLowerCase()) {
        case "list":
            return new ListCommand();
        case "mark":
            int markIndex = Integer.parseInt(args) - 1;
            return new MarkCommand(markIndex);
        case "unmark":
            int unmarkIndex = Integer.parseInt(args) - 1;
            return new UnmarkCommand(unmarkIndex);
        case "delete":
            int delIndex = Integer.parseInt(args) - 1;
            return new DeleteCommand(delIndex);
        case "find":
            return new FindCommand(args);
        case "todo":
            return new AddToDoCommand(args);
        case "deadline":
            return new AddDeadlineCommand(args);
        case "event":
            return new AddEventCommand(args);
        case "bye":
            return new ExitCommand();
        default:
            throw new AmogusException("Unknown command: " + commandWord);
        }
    }

}

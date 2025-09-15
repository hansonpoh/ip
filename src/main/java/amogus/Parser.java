package amogus;

import command.AddDeadlineCommand;
import command.AddEventCommand;
import command.AddToDoCommand;
import command.Command;
import command.CommandType;
import command.DeleteCommand;
import command.ExitCommand;
import command.FindCommand;
import command.ListCommand;
import command.MarkCommand;
import command.TagCommand;
import command.UnmarkCommand;

/**
 * This class deals with user input and returns the
 * correct command to be executed.
 */
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

        CommandType type = CommandType.fromString(commandWord);

        switch (type) {
        case LIST:
            return new ListCommand();
        case MARK:
            int markIndex = Integer.parseInt(args) - 1;
            return new MarkCommand(markIndex);
        case UNMARK:
            int unmarkIndex = Integer.parseInt(args) - 1;
            return new UnmarkCommand(unmarkIndex);
        case DELETE:
            int delIndex = Integer.parseInt(args) - 1;
            return new DeleteCommand(delIndex);
        case FIND:
            return new FindCommand(args);
        case TAG:
            return new TagCommand(args);
        case TODO:
            return new AddToDoCommand(args);
        case DEADLINE:
            return new AddDeadlineCommand(args);
        case EVENT:
            return new AddEventCommand(args);
        case BYE:
            return new ExitCommand();
        default:
            throw new AmogusException("Unknown command: " + commandWord);
        }
    }

}

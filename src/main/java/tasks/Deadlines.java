package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import amogus.AmogusException;

/**
 * Represents a Deadlines object.
 */
public class Deadlines extends Task {
    private final LocalDateTime byDate;
    /**
     * Creates the Tasks.Deadlines object.
     *
     * @param description description of Tasks.Deadlines task
     * @param by deadline
     * @throws AmogusException insufficient information to create deadlines
     */
    public Deadlines(String description, String by) throws AmogusException {
        super(description);
        if (Objects.equals(description, "") || Objects.equals(by, "")) {
            throw new AmogusException("Oh no! Please provide full information regarding your deadline!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        this.byDate = LocalDateTime.parse(by, formatter);
    }

    /**
     * Returns the type of task.
     * @return deadline type of task.
     */
    @Override
    public String getType() {
        return "D";
    }

    /**
     * Correct display of task for easier understanding.
     * @return display string of task.
     */
    @Override
    public String getDisplayString() {
        return "[" + getType() + "][" + (isDone() ? "X" : " ") + "] "
                + getDescription() + " (by: " + byDate.toString() + ")" + getTag();
    }

    /**
     * @return String representation of Deadline task.
     */
    @Override
    public String toString() {
        String type = "D | ";
        return type + super.toString() + " (by: " + byDate.toString() + ")" + this.getTag();
    }

}

package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import amogus.AmogusException;

/**
 * Represents an Event object.
 */
public class Event extends Task {

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    /**
     * Creates the Tasks.Event object.
     *
     * @param description description of Tasks.Event task
     * @param start start date
     * @param end end date
     * @throws AmogusException insufficient information to create Tasks.Event task
     */
    public Event(String description, String start, String end) throws AmogusException {
        super(description);
        if (Objects.equals(description, "") || Objects.equals(start, "") || Objects.equals(end, "")) {
            throw new AmogusException("Oh no! Please provide full information regarding your event!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        this.startDate = LocalDateTime.parse(start, formatter);
        this.endDate = LocalDateTime.parse(end, formatter);
    }

    /**
     * Returns the type of task.
     * @return event type of task.
     */
    @Override
    public String getType() {
        return "E";
    }

    /**
     * Correct display of task for easier understanding.
     * @return display string of task.
     */
    @Override
    public String getDisplayString() {
        return "[" + getType() + "][" + (isDone() ? "X" : " ") + "] "
                + getDescription() + " (from: " + startDate.toString()
                + " to: " + endDate.toString() + ")" + getTag();
    }

    /**
     * @return string representation of Event task
     */
    @Override
    public String toString() {
        String type = "E | ";
        return type + super.toString() + " (from: " + startDate.toString()
                + " to: " + endDate.toString() + ")" + this.getTag();
    }

}

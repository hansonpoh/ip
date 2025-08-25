package Tasks;

import Amogus.AmogusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Event extends Task {
    private final String start;
    private final String end;
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
        this.start = start;
        this.end = end;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        this.startDate = LocalDateTime.parse(start, formatter);
        this.endDate = LocalDateTime.parse(end, formatter);
    }

    @Override
    public String toString() {
        String type = "E | ";
        return type + super.toString() + " (from: " + startDate.toString() + " to: " + endDate.toString() + ")";
    }

    public String start() {
        return this.start;
    }

    public String end() {
        return this.end;
    }
}

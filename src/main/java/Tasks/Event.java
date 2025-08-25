package Tasks;

import Amogus.AmogusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Event extends Task {
    private String type = "E | ";
    private String start;
    private String end;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


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
        return type + super.toString() + " (from: " + startDate.toString() + " to: " + endDate.toString() + ")";
    }

    public String start() {
        return this.start;
    }

    public String end() {
        return this.end;
    }
}

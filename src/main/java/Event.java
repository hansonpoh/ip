import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private String type = "E | ";
    private String start;
    private String end;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    public Event(String description, String start, String end) throws AmogusException {
        super(description);
        if (description == "" || start == "" || end == "") {
            throw new AmogusException("Oh no! Please provide full information regarding your event!");
        }
        this.start = start;
        this.end = end;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        this.startDate = LocalDateTime.parse(start, formatter);
        this.endDate = LocalDateTime.parse(end, formatter);
    }

    @Override
    public String fullDesc() {
        return type + super.fullDesc() + " (from: " + startDate.toString() + " to: " + endDate.toString() + ")";
    }

    public String start() {
        return this.start;
    }

    public String end() {
        return this.end;
    }
}

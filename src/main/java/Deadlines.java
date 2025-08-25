import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task {
    private String type = "D | ";
    private String by;
    private LocalDateTime byDate;

    public Deadlines(String description, String by) throws AmogusException {
        super(description);
        if (description == "" || by == "") {
            throw new AmogusException("Oh no! Please provide full information regarding your deadline!");
        }
        this.by = by;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        this.byDate = LocalDateTime.parse(by, formatter);
    }

    @Override
    public String fullDesc() {
        return type + super.fullDesc() + " (by: " + byDate.toString() + ")";
    }

    public String by() {
        return this.by;
    }
}

package Tasks;

import Amogus.AmogusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Deadlines extends Task {
    private String type = "D | ";
    private String by;
    private LocalDateTime byDate;

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
        this.by = by;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        this.byDate = LocalDateTime.parse(by, formatter);
    }

    @Override
    public String toString() {
        return type + super.toString() + " (by: " + byDate.toString() + ")";
    }

    public String by() {
        return this.by;
    }
}

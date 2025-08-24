public class Event extends Task {
    protected String type = "E | ";
    protected String start;
    protected String end;

    public Event(String description, String start, String end) throws AmogusException {
        super(description);
        if (description == "" || start == "" || end == "") {
            throw new AmogusException("Oh no! Please provide full information regarding your event!");
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public String fullDesc() {
        return type + super.fullDesc() + " (from: " + start + " to: " + end + ")";
    }

    public String start() {
        return this.start;
    }

    public String end() {
        return this.end;
    }
}

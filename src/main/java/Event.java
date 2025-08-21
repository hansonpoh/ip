public class Event extends Task {
    protected String type = "[E]";
    protected String start;
    protected String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String fullDesc() {
        return type + super.fullDesc() + " (from: " + start + " to: " + end + ")";
    }
}

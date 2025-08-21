public class Deadlines extends Task {
    protected String type = "[D]";
    protected String by;

    public Deadlines(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String fullDesc() {
        return type + super.fullDesc() + " (by: " + by + ")";
    }
}

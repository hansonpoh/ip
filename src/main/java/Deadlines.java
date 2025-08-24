public class Deadlines extends Task {
    protected String type = "D | ";
    protected String by;

    public Deadlines(String description, String by) throws AmogusException {
        super(description);
        if (description == "" || by == "") {
            throw new AmogusException("Oh no! Please provide full information regarding your deadline!");
        }
        this.by = by;
    }

    @Override
    public String fullDesc() {
        return type + super.fullDesc() + " (by: " + by + ")";
    }

    public String by() {
        return this.by;
    }
}

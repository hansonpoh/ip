public class ToDo extends Task {
    protected String type = "[T]";

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String fullDesc() {
        return type + super.fullDesc();
    }
}

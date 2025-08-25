import java.util.Objects;

public class ToDo extends Task {
    protected String type = "T | ";

    /**
     * Creates the ToDo object.
     *
     * @param description description of ToDo task
     * @throws AmogusException insufficient information to create task
     */
    public ToDo(String description) throws AmogusException{
        super(description);
        if (Objects.equals(description, "")) {
            throw new AmogusException("Oh no! Please provide full information regarding your todo!");
        }
    }

    @Override
    public String toString() {
        return type + super.toString();
    }
}

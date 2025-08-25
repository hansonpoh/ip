package Tasks;

import Amogus.AmogusException;

import java.util.Objects;

public class ToDo extends Task {

    /**
     * Creates the Tasks.ToDo object.
     *
     * @param description description of Tasks.ToDo task
     * @throws AmogusException insufficient information to create task
     */
    public ToDo(String description) throws AmogusException {
        super(description);
        if (Objects.equals(description, "")) {
            throw new AmogusException("Oh no! Please provide full information regarding your todo!");
        }
    }

    /**
     *
     * @return string representation of ToDo task
     */
    @Override
    public String toString() {
        String type = "T | ";
        return type + super.toString();
    }
}

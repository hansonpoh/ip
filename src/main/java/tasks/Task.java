package tasks;

public class Task {

    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Checks the isDone attribute of the object to check status
     * of the object
     *
     * @return 1 or 0 depending on whether the task has been completed
     */
    public String getStatusIcon() {
        return (isDone ? "1" : "0");
    }

    /**
     *
     * @return string representation of Task
     */
    public String toString() {
        return this.getStatusIcon() + " | " + this.description;
    }

    /**
     * Mark task as complete.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Mark task as incomplete.
     */
    public void unmark() {
        this.isDone = false;
    }

}

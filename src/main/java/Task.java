public class Task {
    protected String description;
    protected boolean isDone;

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

    public String toString() {
        return this.getStatusIcon() + " | " + this.description;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

}

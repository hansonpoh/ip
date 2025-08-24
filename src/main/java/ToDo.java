public class ToDo extends Task {
    protected String type = "T | ";

    public ToDo(String description) throws AmogusException{
        super(description);
        if (description == "") {
            throw new AmogusException("Oh no! Please provide full information regarding your todo!");
        }
    }

    @Override
    public String fullDesc() {
        return type + super.fullDesc();
    }
}

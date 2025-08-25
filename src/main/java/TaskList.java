import java.util.ArrayList;

public class TaskList {

    static ArrayList<Task> tasks = new ArrayList<Task>();

    public Task get(int idx) {
        return tasks.get(idx);
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void delete(int idx) {
        tasks.remove(idx);
    }

    public void mark(int idx) {
        tasks.get(idx).mark();
    }

    public void unmark(int idx) {
        tasks.get(idx).unmark();
    }

    public String taskDesc(int idx) {
        return tasks.get(idx).toString();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public int size() {
        return tasks.size();
    }
}

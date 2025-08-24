import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileStorage {

    private final String path;

    public FileStorage(String path) {
        this.path = path;
    }

    public void saveTasks(TaskList tasks) {
        try (FileWriter fw = new FileWriter(path)) {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                fw.write(task.fullDesc() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public TaskList loadTasks() throws AmogusException, IOException {
        TaskList tasks = new TaskList();
        File f = new File(path);

        if (!f.exists()) {
            f.createNewFile();
            return tasks;
        }

        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                String line = s.nextLine();
                Task task = parseTask(line);
                tasks.add(task);
            }
        }

        return tasks;
    }

    private Task parseTask(String line) throws AmogusException {
        String[] parts = line.split("\\|");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        String type = parts[0];
        boolean isDone = parts[1].equals("1");

        switch (type) {
            case "T":
                ToDo todo = new ToDo(parts[2]);
                if (isDone) todo.mark();
                return todo;

            case "D":
                if (parts.length < 4) throw new AmogusException("Invalid deadline format");
                Deadlines deadlines = new Deadlines(parts[2], parts[3]);
                if (isDone) deadlines.mark();
                return deadlines;

            case "E":
                if (parts.length < 4) throw new AmogusException("Invalid event format");
                String[] times = parts[3].split("-", 2);
                if (times.length < 2) throw new AmogusException("Invalid event time format");
                Event event = new Event(parts[2], times[0], times[1]);
                if (isDone) event.mark();
                return event;

            default:
                throw new AmogusException("Unknown task type: " + type);
        }
    }
}

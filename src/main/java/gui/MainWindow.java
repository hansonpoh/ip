package gui;

import amogus.Amogus;
import amogus.AmogusException;
import amogus.FileStorage;
import amogus.Parser;
import amogus.UI;
import command.Command;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import tasks.TaskList;

import java.io.IOException;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Amogus duke;
    private static final String path = "./data/Tasks.TaskList.txt";

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Duke instance */
    public void setDuke(Amogus d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() throws AmogusException {
        String input = userInput.getText();
        Parser parser = new Parser();
        FileStorage fs = new FileStorage(path);
        TaskList tasks;
        UI ui = new UI();

        try {
            tasks = fs.loadTasks();
        } catch (AmogusException | IOException e) {
            System.out.println(e.getMessage());
            tasks = new TaskList();
        }

        Command command = Parser.parse(input);

        String response = command.execute(tasks, ui, fs);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage)
        );
        userInput.clear();
    }
}

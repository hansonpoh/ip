package gui;

import java.io.IOException;

import amogus.Amogus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Represents the stage for displaying the GUI.
 */
public class Main extends Application {

    private Amogus amogus = new Amogus();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setAmogus(amogus);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


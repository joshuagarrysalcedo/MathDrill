package ph.jsalcedo.mathdrill.mathdrill;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        scene.getStylesheets().add("/style.css");
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Math Drill");
        stage.getIcons().add(new Image("/logo.png"));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
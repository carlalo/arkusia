package de.arkusia.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class App extends Application {
    protected LoadController loadController;
    protected SchirmController schirmController;

    protected FXMLLoader loader = new FXMLLoader(
            getClass().getClassLoader().getResource("de/arkusia/ui/Ladebildschirm.fxml"));
    protected FXMLLoader sloader = new FXMLLoader(getClass().getClassLoader().getResource("de/arkusia/ui/schirm.fxml"));

    private Parent root;
    private Parent load;

    private Scene scene;

    private Stage mainStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        mainStage = stage;
        mainStage.requestFocus();
        try {
            root = sloader.load();
            schirmController = sloader.getController();
            scene = new Scene(root);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(4);
        }

        mainStage.setScene(scene);
        mainStage.setFullScreen(true);
        mainStage.setFullScreenExitHint("");
        mainStage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("ESC"));
        mainStage.show();

        new Thread(() -> laden()).start();
    }

    public void laden() {
        try {
            load = loader.load();
            loadController = loader.getController();

        } catch (Exception e) {
        }
        schirmController.mitteEinfuegen(load);

        loadController.setProgress(0);
        for (int counter = 0; counter <= 10; ++counter) {
            loadController.setProgress(counter);
            sleep(500);
        }
        loadController.setProgress(50);
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {

        }
    }
}

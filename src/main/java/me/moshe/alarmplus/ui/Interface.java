package me.moshe.alarmplus.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.border.utilities.utils.URLUtils;
import me.moshe.alarmplus.ui.controllers.AlarmPlusMainController;

import java.io.IOException;

public class Interface extends Application {
    private Stage window;



    public void start(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.window = primaryStage;
        openMainMenu();
    }

    private void openMainMenu() throws IOException {
        window.setTitle("AlarmPlus");
        window.setResizable(false);

        FXMLLoader loader = new FXMLLoader(URLUtils.getURL("/view/AlarmPlusMain.fxml"));
        Parent root = loader.load();
        AlarmPlusMainController alarmPlusMainController = loader.getController();
        window.setScene(new Scene(root, 1024, 768));
        window.show();
        alarmPlusMainController.focus();
    }
}

package vip.teamemerald.moon.controllers;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class SplashScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Path is relative to the resources folder
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SplashScreen.fxml"));
        Parent root = loader.load();

        stage.initStyle(StageStyle.UTILITY);
        stage.setOpacity(0);
        stage.setHeight(0);
        stage.setWidth(0);
        stage.show();
        
        Stage mainStage = new Stage();
        mainStage.initStyle(StageStyle.UNDECORATED);
        mainStage.initOwner(stage);

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.initStyle(StageStyle.UNDECORATED);
        mainStage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(10));
        delay.setOnFinished(event -> {
            stage.close();
            try { new ProjectManager().start(new Stage()); } catch (Exception e) { e.printStackTrace(); }
        });
        delay.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

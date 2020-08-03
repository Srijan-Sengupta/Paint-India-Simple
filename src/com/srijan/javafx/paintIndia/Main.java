package com.srijan.javafx.paintIndia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Entry point of the Application:
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PaintIndia.fxml"));
        primaryStage.setTitle("Paint-India");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

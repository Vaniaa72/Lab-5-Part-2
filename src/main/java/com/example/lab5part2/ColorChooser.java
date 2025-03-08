package com.example.lab5part2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ColorChooser extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file that specifies the layout of the UI
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ColorChooser.fxml"));
            Parent root = loader.load();

            // Set the title of the Stage (the main window)
            primaryStage.setTitle("Color Chooser");

            // Set the scene with the FXML loaded layout
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);

            // Show the Stage (the window)
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }
}
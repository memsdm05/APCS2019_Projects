package Unit2.Converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BaseConverterGUI extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "index.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        TabPane root = (TabPane) loader.load(fxmlStream);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Ben's Base Converter");
        stage.show();
    }
}
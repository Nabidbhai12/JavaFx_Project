package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage stage;
    public Stage getStage()
    {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        new Container(stage,this);

    }



    public static void main(String[] args) {

        launch(args);
    }
}

package br.ufla.sistemas.cinema;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
        
        VBox root = (VBox) loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Cinema");
        stage.setScene(scene);
        stage.setMinWidth(900);
        stage.setMinHeight(700);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

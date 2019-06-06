package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Pane root = FXMLLoader.load( getClass().getResource("TelaPrincipal.fxml") );
		
		Scene cena = new Scene(root, 600, 400); 
		primaryStage.setScene(cena);
		primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

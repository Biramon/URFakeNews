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
		Pane root = FXMLLoader.load( getClass().getResource("../br/ufrn/imd/visao/TelaPrincipal.fxml") );
		
		Scene cena = new Scene(root); 
		primaryStage.setScene(cena);
		primaryStage.setTitle("U R Fake News!");
		primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

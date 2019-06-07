package br.ufrn.imd.controle;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class TelaPrincipalController {

    @FXML
    private MenuItem menuAbrirArquivo;

    @FXML
    private MenuItem miAlterarTamanhoCorte;

    @FXML
    private MenuItem miSobre;

    @FXML
    private Label labelCreditos;

    @FXML
    private ImageView imagemLogo;

    @FXML
    private Label labelInfoUsuario;

    @FXML
    private TextField textfieldURL;

    @FXML
    private Button btAnalisarNoticia;

    @FXML
    private Slider slLimiarConfianca;

    @FXML
    private Label lvalorLimiar;
    

    @FXML
    void AnalisarNoticia(ActionEvent event) {

    }

    @FXML
    void abrirArquivoBase(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	fc.getExtensionFilters().add( new ExtensionFilter("Arquivos CSV", "*.csv"));
    	File f = fc.showOpenDialog(null);
    	
    	//Apenas para teste, depois pegar o caminho absoluto para poder jogar para as classes de modelo
    	if (f != null) System.out.println(f.getAbsolutePath());
    }
    
    @FXML
    void SliderLimiarFoiSolto(MouseEvent event) {
    	lvalorLimiar.setText( String.format("%.0f", slLimiarConfianca.getValue()) );
    }
    
    @FXML
    void menuitemSobreClicado(ActionEvent event) {
    	try {
    	FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource("../visao/TelaSobre.fxml") );	
		Parent root1 = (Parent) fxmlLoader.load();
		
		Stage stage = new Stage();
		Scene cenateste = new Scene(root1);
		
		stage.setScene(cenateste);
		stage.setResizable(false);
		stage.setTitle("Sobre");
		stage.show();
		} catch (IOException e) {
			System.out.println("N�o deu certo abrir a janela!");
			e.printStackTrace();
		}
    	
    }
    

    @FXML
    void miAlterarTamanhoCorteClicado(ActionEvent event) {
    	try {
        	FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource("../visao/TelaAlterarTamanhoCorte.fxml") );	
    		Parent root1 = (Parent) fxmlLoader.load();
    		
    		Stage stage = new Stage();
    		   		
    		stage.setScene(new Scene(root1));
    		stage.setResizable(false);
    		stage.setTitle("Alterar Tamanho de Corte");
    		stage.show();
    		} catch (IOException e) {
    			System.out.println("N�o deu certo abrir a janela!");
    			e.printStackTrace();
    		}
    }
}

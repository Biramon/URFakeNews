package br.ufrn.imd.controle;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    }
    
    @FXML
    void SliderLimiarFoiSolto(MouseEvent event) {
    	lvalorLimiar.setText( String.format("%.0f", slLimiarConfianca.getValue()) );
    }
    
    @FXML
    void menuitemSobreClicado(ActionEvent event) throws IOException {
    	Parent TelaSobreParent = FXMLLoader.load(getClass().getResource("TelaSobre.fxml"));
    	Scene SobreScene = new Scene (TelaSobreParent);
    	
    	Stage janelaSobre = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	janelaSobre.setScene(SobreScene);
    	janelaSobre.setTitle("Sobre");
    	janelaSobre.show();
    	
    }
}

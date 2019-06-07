package br.ufrn.imd.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaAlterarTamanhoCorteController {

    @FXML
    private TextField tfAlterarCorte;

    @FXML
    private Button btAlterar;

    @FXML
    private Button btFechar;

    @FXML
    void btAlterarClicado(ActionEvent event) 	{

    }

    @FXML
    void btFecharClicado(ActionEvent event) {
    	Stage telaSobre = (Stage) btFechar.getScene().getWindow();
    	
    	telaSobre.close();
    }

}

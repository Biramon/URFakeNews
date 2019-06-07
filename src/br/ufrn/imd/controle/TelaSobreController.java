package br.ufrn.imd.controle;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaSobreController {

    @FXML
    private Button btFechar;

    @FXML
    void botaoFecharClicado(ActionEvent event) throws IOException {
    	Stage telaSobre = (Stage) btFechar.getScene().getWindow();
    	
    	telaSobre.close();
    }

}


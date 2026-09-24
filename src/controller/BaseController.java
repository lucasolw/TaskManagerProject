package controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class BaseController {

    @FXML
    private BorderPane painelBase;

    @FXML
    private void initialize(){
        //Disponibiliza referência para outros controllers acessarem

    }

    public void setarConteudoCentral(Parent conteudo){
        painelBase.setCenter(conteudo);
    }
}

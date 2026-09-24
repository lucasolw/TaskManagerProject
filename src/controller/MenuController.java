package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MenuController {
    private static BaseController baseController;

    public static void setBaseController(BaseController controller){
        baseController = controller;
    }

    @FXML
    public void abrirTelaCadastro(){
        try {
            Parent tela = FXMLLoader.load(getClass().getResource("/fxml/TelaPrincipal.fxml"));
            baseController.setarConteudoCentral(tela);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

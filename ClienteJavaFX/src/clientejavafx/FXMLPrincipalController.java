/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejavafx;

import clientejavafx.utilidades.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author juanl
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private Button btCerrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cerrarSesion(ActionEvent event) {
        try {
            Stage esenario = (Stage) btCerrar.getScene().getWindow();
            Parent login = FXMLLoader.load(getClass().getResource("FXMLInicioSesion.fxml"));
            Scene esenaLogin = new Scene(login);
            esenario.setScene(esenaLogin);
            esenario.setTitle("Login");
            esenario.show();
        } catch (IOException ex) {
            Utilidades.mostrarAlerta("Error", "Erro 404", Alert.AlertType.ERROR);
        }catch(RuntimeException e){
            Utilidades.mostrarAlerta("Error", "Erro 404", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void irAdminColaboradores(ActionEvent event) {
        try {
            Stage ecenario = new Stage();
            Parent administrador = FXMLLoader.load(getClass().getResource("FXMLAdminColaborador.fxml"));
            Scene scene = new Scene(administrador);
            ecenario.setScene(scene);
            ecenario.setTitle("Administrador Colaboradores");
            ecenario.initModality(Modality.APPLICATION_MODAL);
            ecenario.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

package clientejavafx;

import clientejavafx.modelo.dao.LoginDAO;
import clientejavafx.utilidades.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.Login;

/**
 *
 * @author juanl
 */
public class FXMLInicioSesionController implements Initializable {

    @FXML
    private TextField tfCorreo;
    @FXML
    private PasswordField tpContrasena;
    @FXML
    private Label tfErrorCorreo;
    @FXML
    private Label tfErrorContrasena;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickIngresar(ActionEvent event) {
        String correo = tfCorreo.getText();
        String contrasena = tpContrasena.getText();
        if(validarCampos(correo, contrasena)){
            verificarCredencialesSistema(correo, contrasena);
        }else{
            
        }
    }
    private void verificarCredencialesSistema(String noPersonal, String password){
        Login respuesta = LoginDAO.iniciarSesion(noPersonal, password);
        if(!respuesta.isError()){
            Utilidades.mostrarAlerta("Bienvenido", "Bienvenido " + respuesta.getColaborador().getNombre(), Alert.AlertType.INFORMATION);
            irPantallaPrincipal();
        }else{
            Utilidades.mostrarAlerta("Atención", respuesta.getMensaje(), Alert.AlertType.ERROR);
        }
    }
    
    private boolean validarCampos(String correo, String contrasena){
        boolean camposValidos = true;
        
        if(correo.isEmpty()){
            camposValidos = false;
            tfErrorCorreo.setText("Numero Personal Obligatorio");
        }
        if(contrasena.isEmpty()){
            camposValidos = false;
            tfErrorContrasena.setText("Contraseña Obligatoria");
        }
        return camposValidos;
    }
    private void irPantallaPrincipal(){
        try {
            Stage esenario = (Stage) tfCorreo.getScene().getWindow();
            Parent principal = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
            Scene ecenaPrincipal = new Scene(principal);
            esenario.setScene(ecenaPrincipal);
            esenario.setTitle("Pantalla principal");
            esenario.show();
        } catch (IOException | RuntimeException ex) {
            Utilidades.mostrarAlerta("Error", "Erro 404", Alert.AlertType.ERROR);
        }
        
    }
}

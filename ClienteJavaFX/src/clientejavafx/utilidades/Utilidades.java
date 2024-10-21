package clientejavafx.utilidades;

import javafx.scene.control.Alert;

/**
 *
 * @author juanl
 */
public class Utilidades {
    
    public static void mostrarAlerta(String titulo, String Contenido, Alert.AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(Contenido);
        alerta.showAndWait();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejavafx;

import clientejavafx.modelo.dao.ColaboradorDAO;
import clientejavafx.observador.NotificadoOperacion;
import clientejavafx.utilidades.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojo.Colaborador;
import pojo.Mensaje;

/**
 * FXML Controller class
 *
 * @author juanl
 */
public class FXMLAdminColaboradorController implements Initializable, NotificadoOperacion {

    private ObservableList<Colaborador> colaboradores;

    @FXML
    private TableView<Colaborador> tvTablaColaboradores;
    @FXML
    private TableColumn colNoPersonal;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoPaterno;
    @FXML
    private TableColumn colApellidoMaterno;
    @FXML
    private TableColumn colFechaNacimiento;
    @FXML
    private TableColumn colTelefono;
    @FXML
    private TableColumn colTipo;
    @FXML
    private TextField tfBuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabla();
        cargarLaInformacion();
    }

    private void configurarTabla() {
        colNoPersonal.setCellValueFactory(new PropertyValueFactory("noPersonal"));
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colApellidoPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        colApellidoMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        colTipo.setCellValueFactory(new PropertyValueFactory("rol"));
    }

    private void cargarLaInformacion() {
        colaboradores = FXCollections.observableArrayList();
        List<Colaborador> lista = ColaboradorDAO.obtenerColaboradores();
        if (lista != null) {
            colaboradores.addAll(lista);
            tvTablaColaboradores.setItems(colaboradores);
        }else{
            Utilidades.mostrarAlerta("ERROR", "Lo sentimos por el momento no se puede cargar la informacion"
                    + "de los Colaboradores, por favor intentélo mas tarde", Alert.AlertType.ERROR);
            cerrarVentana();
        }
      
    }
    
    private void cerrarVentana(){
        ((Stage) tfBuscar.getScene().getWindow()).close();
     }

    @FXML
    private void editarColaborador(ActionEvent event) {
        Colaborador colaborador = tvTablaColaboradores.getSelectionModel().getSelectedItem();
        if(colaborador!= null){
            iraFormulario(this, colaborador);
        }else{
            Utilidades.mostrarAlerta("Error", "Selecciona un colaborador", Alert.AlertType.ERROR);
        }
    }
    @FXML
    private void agregarColaborador(ActionEvent event) {
        iraFormulario(this, null);
    }

    @FXML
    private void eliminarColaborador(ActionEvent event) {
        Colaborador colaborador = tvTablaColaboradores.getSelectionModel().getSelectedItem();
        if(colaborador!= null){
            Mensaje mensaje = ColaboradorDAO.eliminarColaborador(colaborador.getNoPersonal());
            if(!mensaje.isError()){
                Utilidades.mostrarAlerta("Correcto", "Colaborador agregado correctamente", Alert.AlertType.INFORMATION);
                cargarLaInformacion();
            }else{
                Utilidades.mostrarAlerta("Error", mensaje.getMensaje(), Alert.AlertType.ERROR);
            }
            
        }else{
            Utilidades.mostrarAlerta("Error", "Selecciona un colaborador", Alert.AlertType.ERROR);
        }
    }
    private void iraFormulario(NotificadoOperacion observador, Colaborador colaborador){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLFormularioColaborador.fxml"));
            Parent root = loader.load();
            
            FXMLFormularioColaboradorController controlador = loader.getController();
            controlador.initializeValores(observador, colaborador);
            
            Stage ecena = new Stage();
            Scene ecenario = new Scene(root);
            ecena.setScene(ecenario);
            ecena.setTitle("Formulario Colaboador");
            ecena.initModality(Modality.APPLICATION_MODAL);
            ecena.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(FXMLAdminColaboradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void notificarOperacion(String tipo, String nombre) {
        System.out.println("tipo:" + tipo +"Nombre:" + nombre);
        cargarLaInformacion();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejavafx;

import clientejavafx.modelo.dao.ColaboradorDAO;
import clientejavafx.modelo.dao.RolDAO;
import clientejavafx.observador.NotificadoOperacion;
import clientejavafx.utilidades.Utilidades;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.Colaborador;
import pojo.Mensaje;
import pojo.Rol;

/**
 * FXML Controller class
 *
 * @author juanl
 */
public class FXMLFormularioColaboradorController implements Initializable {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidoM;
    @FXML
    private TextField tfApellidoP;
    @FXML
    private TextField tfNoPersonal;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField tfRFC;
    @FXML
    private TextField tfCurp;
    @FXML
    private TextField tfContrasena;
    @FXML
    private DatePicker dpFechaNacimiento;
    @FXML
    private ComboBox<Rol> cbRol;
    
    private NotificadoOperacion observador; 
    private Colaborador colaboradorEditado;
    private boolean modoEdicion = false;
    ObservableList<Rol> tiposDeColaboradores;
    @FXML
    private Button btFormulario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTiposDeUsuarios();
    }    
    
    public void initializeValores(NotificadoOperacion observador, Colaborador colaboradorEditado){
        this.colaboradorEditado = colaboradorEditado;
        this.observador = observador;
        if(colaboradorEditado!=null){
            modoEdicion = true;
            llenarcampos();
            btFormulario.setText("Editar");
        }
    }

    @FXML
    private void agregarColaborador(ActionEvent event) {
        Colaborador colaborador = new Colaborador();
        colaborador.setNombre(tfNombre.getText());
        colaborador.setApellidoPaterno(tfApellidoP.getText());
        colaborador.setApellidoMaterno(tfApellidoM.getText());
        colaborador.setNoPersonal(tfNoPersonal.getText());
        colaborador.setTelefono(tfTelefono.getText());
        colaborador.setFechaNacimiento(dpFechaNacimiento.getValue() != null ? dpFechaNacimiento.getValue().toString() : "");
        colaborador.setCorreo(tfCorreo.getText());
        colaborador.setRfc(tfRFC.getText());
        colaborador.setCurp(tfCurp.getText());
        colaborador.setPassword(tfContrasena.getText());
        colaborador.setIdRol((cbRol.getSelectionModel().getSelectedItem() != null)?
                cbRol.getSelectionModel().getSelectedItem().getIdRol(): -1
        );
        if(validarCampos(colaborador)){
            if(!modoEdicion){
                guardarDatosColaborador(colaborador);
            }else{
                colaborador.setIdColaborador(colaboradorEditado.getIdColaborador());
                editarDatosColaborador(colaborador);
            }
            
        }else{
            Utilidades.mostrarAlerta("Campos Obligatorios", "Hubo un error al llenar los campos", Alert.AlertType.ERROR);
        }
    }
    private boolean validarCampos(Colaborador colaborador) {
    if (colaborador.getNombre() == null || colaborador.getNombre().isEmpty() ||
        colaborador.getApellidoMaterno() == null || colaborador.getApellidoMaterno().isEmpty() ||
        colaborador.getApellidoPaterno() == null || colaborador.getApellidoPaterno().isEmpty() ||
        colaborador.getCorreo() == null || colaborador.getCorreo().isEmpty() ||
        colaborador.getCurp() == null || colaborador.getCurp().isEmpty() ||
        colaborador.getFechaNacimiento() == null || colaborador.getFechaNacimiento().isEmpty() ||
        colaborador.getIdColaborador() == null ||
        colaborador.getNoPersonal() == null || colaborador.getNoPersonal().isEmpty() ||
        colaborador.getPassword() == null || colaborador.getPassword().isEmpty() ||
        colaborador.getRfc() == null || colaborador.getRfc().isEmpty() ||
        colaborador.getTelefono() == null || colaborador.getTelefono().isEmpty() ||
        colaborador.getIdRol() == null) {
        return false;
    }
    return true;
}

    
    private void guardarDatosColaborador(Colaborador colaborador){
        Mensaje msj = ColaboradorDAO.registrarColaborador(colaborador);
        if(!msj.isError()){
            Utilidades.mostrarAlerta("Registro Exitoso", "Todo good", Alert.AlertType.INFORMATION);
            observador.notificarOperacion("Guardar", colaborador.getNombre());
            cerrarVentana();
        }else{
            Utilidades.mostrarAlerta("Error", "Todo bad", Alert.AlertType.ERROR);
        }
    }
    private void cerrarVentana(){
        Stage base = (Stage) tfNombre.getScene().getWindow();
        base.close();
    }
    
    private void cargarTiposDeUsuarios(){
        tiposDeColaboradores = FXCollections.observableArrayList();
        tiposDeColaboradores.addAll(RolDAO.optenerRoles());  
        cbRol.setItems(tiposDeColaboradores);
    }
    
    
    private void editarDatosColaborador(Colaborador colaborador){
        Mensaje msj = ColaboradorDAO.editarColaborador(colaborador);
        if(!msj.isError()){
            Utilidades.mostrarAlerta("Registro Exitoso", "Todo good", Alert.AlertType.INFORMATION);
            observador.notificarOperacion("Guardar", colaborador.getNombre());
            cerrarVentana();
        }else{
            Utilidades.mostrarAlerta("Error", "Todo bad", Alert.AlertType.ERROR);
        }
    }

    private void llenarcampos() {
        tfNombre.setText(colaboradorEditado.getNombre());
        tfApellidoM.setText(colaboradorEditado.getApellidoMaterno());
        tfApellidoP.setText(colaboradorEditado.getApellidoPaterno());
        tfContrasena.setText(colaboradorEditado.getPassword());
        tfCorreo.setText(colaboradorEditado.getCorreo());
        tfCurp.setText(colaboradorEditado.getCurp());
        tfNoPersonal.setText(colaboradorEditado.getNoPersonal());
        tfRFC.setText(colaboradorEditado.getRfc());
        tfTelefono.setText(colaboradorEditado.getTelefono());
        tfNoPersonal.setEditable(false);
        dpFechaNacimiento.setValue(LocalDate.parse(colaboradorEditado.getFechaNacimiento()));
        int posicion = buscarIdRol(colaboradorEditado.getIdRol());
        cbRol.getSelectionModel().select(posicion);
    }
    private int buscarIdRol(int idRol){
        for(int i=0; i<tiposDeColaboradores.size();i++){
            if(tiposDeColaboradores.get(i).getIdRol() == idRol){
                return i;
            }
        }
        return -1;
    }
}

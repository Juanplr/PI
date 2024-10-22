/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejavafx;

import clientejavafx.modelo.dao.ColaboradorDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Colaborador;

/**
 * FXML Controller class
 *
 * @author juanl
 */
public class FXMLAdminColaboradorController implements Initializable {
    
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
    private Button btnEditar;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEliminar;
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
    
    private void configurarTabla(){
        colNoPersonal.setCellValueFactory(new PropertyValueFactory("noPersonal"));
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colApellidoPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        colApellidoMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        colTipo.setCellValueFactory(new PropertyValueFactory("rol"));
    }
    private void cargarLaInformacion(){
        colaboradores = FXCollections.observableArrayList();
        List<Colaborador> lista = ColaboradorDAO.obtenerColaboradores();
        colaboradores.addAll(lista);
        tvTablaColaboradores.setItems(colaboradores);
    }
    
}

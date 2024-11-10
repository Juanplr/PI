package pojo;

/**
 *
 * @author juanl
 */
public class Rutina {
   private Integer idRutina;
   private String nombre;
   private Integer numeroEjercicios;
   private Integer repeticiones;
   private Integer idAparato;
   private Integer idCliente;
   private Integer idColaborador;
   private String nombreAparato;
   private String nombreCliente;
   private String nombreColaborador;

    public Rutina() {
    }

    public Rutina(Integer idRutina, String nombre, Integer numeroEjercicios, Integer repeticiones, Integer idAparato, Integer idCliente, Integer idColaborador, String nombreAparato, String nombreCliente, String nombreColaborador) {
        this.idRutina = idRutina;
        this.nombre = nombre;
        this.numeroEjercicios = numeroEjercicios;
        this.repeticiones = repeticiones;
        this.idAparato = idAparato;
        this.idCliente = idCliente;
        this.idColaborador = idColaborador;
        this.nombreAparato = nombreAparato;
        this.nombreCliente = nombreCliente;
        this.nombreColaborador = nombreColaborador;
    }

    public Integer getIdRutina() {
        return idRutina;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumeroEjercicios() {
        return numeroEjercicios;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public Integer getIdAparato() {
        return idAparato;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public String getNombreAparato() {
        return nombreAparato;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombreColaborador() {
        return nombreColaborador;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroEjercicios(Integer numeroEjercicios) {
        this.numeroEjercicios = numeroEjercicios;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public void setIdAparato(Integer idAparato) {
        this.idAparato = idAparato;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public void setNombreAparato(String nombreAparato) {
        this.nombreAparato = nombreAparato;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNombreColaborador(String nombreColaborador) {
        this.nombreColaborador = nombreColaborador;
    }   
}

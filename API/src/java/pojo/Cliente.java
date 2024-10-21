package pojo;

/**
 *
 * @author juanl
 */
public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String telefono;
    private float peso;
    private int estatura;
    private String correo;
    private String password;
    private int idRol;
    private String rol;

    public Cliente() {
    }
    
    public Cliente(int idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String telefono, float peso, int estatura, String correo, String password, int idRol, String rol) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.peso = peso;
        this.estatura = estatura;
        this.correo = correo;
        this.password = password;
        this.idRol = idRol;
        this.rol = rol;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public float getPeso() {
        return peso;
    }

    public int getEstatura() {
        return estatura;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public int getIdRol() {
        return idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}

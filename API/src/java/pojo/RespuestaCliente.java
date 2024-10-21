package pojo;

import java.util.List;

/**
 *
 * @author juanl
 */
public class RespuestaCliente {
    private boolean error;
    private String mensaje;
    private List<Cliente> clientes;

    public RespuestaCliente() {
    }

    public RespuestaCliente(boolean error, String mensaje, List<Cliente> clientes) {
        this.error = error;
        this.mensaje = mensaje;
        this.clientes = clientes;
    }

    public boolean isError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}

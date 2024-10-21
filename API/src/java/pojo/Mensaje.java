package pojo;

import java.util.logging.Logger;

/**
 *
 * @author juanl
 */
public class Mensaje {
    private boolean error;
    private String mensaje;

    public Mensaje() {
    }

    public Mensaje(boolean error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }

    public boolean isError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}

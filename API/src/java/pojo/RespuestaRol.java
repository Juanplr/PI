/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.List;

/**
 *
 * @author juanl
 */
public class RespuestaRol {
    private boolean error;
    private String mensaje;
    private List<Rol> roles;

    public RespuestaRol() {
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public RespuestaRol(boolean error, String mensaje, List<Rol> roles) {
        this.error = error;
        this.mensaje = mensaje;
        this.roles = roles;
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

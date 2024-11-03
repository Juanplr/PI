/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpRol;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.RespuestaRol;

/**
 *
 * @author juanl
 */
@Path("roles")
public class WSRol {
    
    @Path("optenerRoles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaRol getClientes(){
        
        return ImpRol.getRoles();
    }
}

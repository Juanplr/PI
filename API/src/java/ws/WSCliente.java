/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpCliente;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.RespuestaCliente;

/**
 *
 * @author juanl
 */
@Path("cliente")
public class WSCliente {
    
    @Path("obtenerClientes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaCliente getClientes(){
        
        return ImpCliente.getClientes();
    }
    
    @Path("obtenerClientesPorCorreo/{correo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaCliente getColaborador(@PathParam("correo") String correo){
         if(!correo.isEmpty()){
            return ImpCliente.cliente(correo);
        }
        throw new BadRequestException();
    }
    
}

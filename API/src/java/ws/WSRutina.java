/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpRutina;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.Rutina;

/**
 *
 * @author juanl
 */
@Path("rutina")
public class WSRutina {
     public WSRutina(){
        
    }
    
    @Path("obtenerRutinas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rutina> getPagos(){
         try{
             return ImpRutina.obtenerRutinas();
        } catch (SQLException ex) {
            throw new BadRequestException();
         }
    }
    
    @Path("obtenerRutinasCliente/{idCliente}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rutina> getPagosCliente(@PathParam("idCliente") Integer idCliente){
        if(idCliente!=null&&idCliente>0){
            try {
                return ImpRutina.obtenerRutinasCliente(idCliente);
            } catch (SQLException ex) {
                throw new BadRequestException();
            }
        }else{
            throw new BadRequestException();
        }
    }
}

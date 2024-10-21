package ws;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import operaciones.ImpOperaciones;
import pojo.ResultadoOperacion;

/**
 *
 * @author juanl
 */

@Path("operaciones")
public class WSOperaciones {
    
    
    @Path("sumar/{num1},{num2}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoOperacion sumar(@PathParam("num1") float num1, @PathParam("num2") float num2){
        return ImpOperaciones.sumar(num1, num2);
    }
    
    @Path("restar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoOperacion restar(@FormParam("num1") Integer num1, @FormParam("num2") Integer num2){
        return ImpOperaciones.restar(num1, num2);
    }
    
    @Path("multiplicar/{num1},{num2}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoOperacion multiplicar(@PathParam("num1") float num1, @PathParam("num2") float num2){
        return ImpOperaciones.multiplicar(num1, num2);
    }
    @Path("dividir/{num1},{num2}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoOperacion dividir(@PathParam("num1") float num1, @PathParam("num2") float num2){
        return ImpOperaciones.dividir(num1, num2);
    }
    @Path("modulo/{num1},{num2}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoOperacion modulo(@PathParam("num1") float num1, @PathParam("num2") float num2){
        return ImpOperaciones.modulo(num1, num2);
    }
}

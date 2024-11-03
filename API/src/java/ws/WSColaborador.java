package ws;

import com.google.gson.Gson;
import dominio.ImpColaborador;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.Colaborador;
import pojo.Mensaje;
import pojo.RespuestaColaborador;

/**
 *
 * @author juanl
 */
@Path("colaborador")
public class WSColaborador {
    
    public WSColaborador(){
    }
    
    @Path("obtenerColaboradores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaColaborador getColaboradores(){
        
        return ImpColaborador.getColaboradores();
    }
    
    @Path("obtenerColaboradorNoPersonal/{noPersonal}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaColaborador getColaborador(@PathParam("noPersonal") String noPersonal){
         if(!noPersonal.isEmpty()){
            return ImpColaborador.colaborador(noPersonal);
        }
        throw new BadRequestException();
    }
    
    @Path("registrar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje iniciarSesionColaborador(String jsoColaborador){
        try {
            Gson gson = new Gson();
            Colaborador colaborador = gson.fromJson(jsoColaborador, Colaborador.class);
            return ImpColaborador.registrarColaborador(colaborador);
        } catch (Exception e) {
             throw new BadRequestException();
        }
    }
    
    @Path("editarColaborador")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarColaborador(String jsoColaborador){
        try {
            Gson gson = new Gson();
            Colaborador colaborador = gson.fromJson(jsoColaborador, Colaborador.class);
            return ImpColaborador.editarColaborador(colaborador);
        } catch (Exception e) {
             throw new BadRequestException();
        }
    }
    
    @Path("eliminarColaborador")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarColaborador(@FormParam("noPersonal") String noPersonal){
        if(!noPersonal.isEmpty()){
            Colaborador colaborador = new Colaborador();
            colaborador.setNoPersonal(noPersonal);
            return ImpColaborador.eliminarColaborador(colaborador);
        }
        throw new BadRequestException();
    }
    
}


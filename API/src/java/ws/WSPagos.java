package ws;


import dominio.ImpPagos;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.Cliente;
import pojo.Pago;
/**
 *
 * @author juanl
 */
@Path("pagos")
public class WSPagos {
    
    public WSPagos(){
        
    }
    
    @Path("obtenerPagos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pago> getPagos(){
        
        return ImpPagos.obtenerPagos();
    }
    
    @Path("obtenerPagos-cliente/{idCliente}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pago> getPagosCliente(@PathParam("idCliente") Integer idCliente){
        if(idCliente!=null&&idCliente>0){
            return ImpPagos.obtenerPagosCliente(idCliente);
        }else{
            throw new BadRequestException();
        }
    }
}

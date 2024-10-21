package ws;

import dominio.ImpLogin;
import java.util.HashMap;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.LoginColaborador;

/**
 * REST Web Service
 *
 * @author juanl
 */
@Path("login")
public class WSLogin {

    @Context
    private UriInfo context;

    public WSLogin() {
    }
    
    @Path("probar-conexion")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public boolean probarConexion(){
        SqlSession conexion = MyBatisUtil.obtenerConexion();
        
        return (conexion!=null);
    }
    
    @Path("colaborador")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public LoginColaborador iniciarSesionColaborador(@FormParam("noPersonal") String noPersonal,@FormParam("password") String password){
        if(!noPersonal.isEmpty() && !password.isEmpty()&& noPersonal.length() <=10){
            return ImpLogin.validarSesionColaborador(noPersonal, password);
        }
        throw new BadRequestException();
    }
}

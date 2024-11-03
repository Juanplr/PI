package dominio;

import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.RespuestaRol;
/**
 *
 * @author juanl
 */
public class ImpRol {
    public static RespuestaRol getRoles(){
        RespuestaRol respuesta = new RespuestaRol();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD !=null){
            try {
                respuesta.setRoles(conexionBD.selectList("roles.getRoles"));
                if(respuesta.getRoles()!= null){
                    respuesta.setError(false);
                    respuesta.setMensaje("Se encontraron Roles");
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("No se encontraron Roles");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no se puede consultar la información.");
        }
        
        
        return respuesta;
    }
}

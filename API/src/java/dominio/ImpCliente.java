package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Cliente;
import pojo.RespuestaCliente;

/**
 *
 * @author juanl
 */
public class ImpCliente {
    public static RespuestaCliente getClientes(){
        RespuestaCliente respuesta = new RespuestaCliente();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD !=null){
            try {
                respuesta.setClientes(conexionBD.selectList("cliente.getClientes"));
                if(respuesta.getClientes()!= null){
                    respuesta.setError(false);
                    respuesta.setMensaje("Se encontraron Clientes");
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("No se encontraron clientes");
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
    
    public static RespuestaCliente cliente(String correo){
        RespuestaCliente respuesta = new RespuestaCliente();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD !=null){
            try {
                ArrayList<Cliente> lista = new ArrayList<>();
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("correo", correo);
                Cliente cliente = conexionBD.selectOne("cliente.getClientePorCorreo", parametros);
                if(cliente != null){
                    lista.add(cliente);
                    respuesta.setClientes(lista);
                    respuesta.setError(false);
                    respuesta.setMensaje("Se encontro el cliente");
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Error correo del cliente incorrecto");
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

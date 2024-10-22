package dominio;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Colaborador;
import pojo.Mensaje;
import pojo.RespuestaColaborador;

/**
 *
 * @author juanl
 */
public class ImpColaborador {
    
    public static RespuestaColaborador getColaboradores(){
        RespuestaColaborador respuesta = new RespuestaColaborador();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD !=null){
            try {
                respuesta.setColaboradores(conexionBD.selectList("colaborador.getColaboradores"));
                if(respuesta.getColaboradores() != null){
                    respuesta.setError(false);
                    respuesta.setMensaje("Se encontraron Colaboradores");
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("No se encontraron colaboradores");
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
    /*public static List<Colaborador> getColaboradores2() throws Exception {
        List<Colaborador> colaboradores = null;
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                colaboradores = conexionBD.selectList("colaborador.getColaboradores");
                if (colaboradores == null) {
                    throw new Exception("No se encontraron colaboradores");
                }
            } catch (Exception e) {
                throw new Exception("Error al obtener colaboradores: " + e.getMessage());
            } finally {
                conexionBD.close(); // No olvides cerrar la conexión en el finally
            }
        } else {
            throw new Exception("Por el momento no se puede consultar la información.");
        } 
        return colaboradores;
    }*/

    
    public static RespuestaColaborador colaborador(String noPersonal){
        RespuestaColaborador respuesta = new RespuestaColaborador();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD !=null){
            try {
                ArrayList<Colaborador> lista = new ArrayList<>();
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("noPersonal", noPersonal);
                Colaborador colaborador = conexionBD.selectOne("colaborador.getColaboradorPorNoPersonal", parametros);
                if(colaborador != null){
                    lista.add(colaborador);
                    respuesta.setColaboradores(lista);
                    respuesta.setError(false);
                    respuesta.setMensaje("Se encontro el colaborador");
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Error numero Personal del colaborador incorrecto");
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
    public static Mensaje registrarColaborador(Colaborador colaborador){
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if(conexionBD !=null){
            try {
                int filasAfectadas = conexionBD.insert("colaborador.registrar", colaborador);
                conexionBD.commit();
                if(filasAfectadas>0){
                    respuesta.setMensaje("Colaborador insertado.");
                    respuesta.setError(false);
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Error, No se realizo la operacion");
                }
            } catch (Exception e) {
                
            }
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("No se puede acceder, intentelo más tarde ");
        }
        
        return respuesta;
    }
}

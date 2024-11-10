package dominio;

/**
 *
 * @author juanl
 */
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Rutina;

public class ImpRutina {

    public static List<Rutina> obtenerRutinas() throws SQLException {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        
        if (conexionBD != null) {
            try {
                List<Rutina> respuesta = conexionBD.selectList("rutinas.obtenerRutinas");
                return respuesta;
            } finally {
                conexionBD.close(); 
            }
        } else {
            throw new SQLException("No se pudo establecer la conexión con la base de datos.");
        }
    }
    
    public static List<Rutina> obtenerRutinasCliente (Integer idCliente) throws SQLException {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        
        if (conexionBD != null) {
            try {
                HashMap<String, Integer> parametros = new LinkedHashMap<>();
                parametros.put("idCliente", idCliente);
                List<Rutina> respuesta = conexionBD.selectList("rutinas.obtenerRutinasCliente",parametros);
                return respuesta;
            }finally {
                conexionBD.close(); 
            }
        } else {
            throw new SQLException("No se pudo establecer la conexión con la base de datos.");
        }
    }
}

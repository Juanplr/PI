package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Cliente;
import pojo.Pago;

/**
 *
 * @author juanl
 */
public class ImpPagos {
   public static List<Pago> obtenerPagos(){
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {

                List<Pago> respuesta = conexionBD.selectList("pagos.obtenerPagos");
                if (respuesta != null) {
                    return respuesta; 
                } else {
                    
                    return new ArrayList<>(); 
                }
            } catch (Exception e) {
                e.printStackTrace(); 
            } finally {
                conexionBD.close(); 
            }
        } else {
            return new ArrayList<>();
        }
        return new ArrayList<>(); 
       
   } 
   public static List<Pago> obtenerPagosCliente(Integer idCliente) {
        SqlSession conexionBD = MyBatisUtil.obtenerConexion();
        if (conexionBD != null) {
            try {
                HashMap<String, Integer> parametros = new LinkedHashMap<>();
                parametros.put("idCliente", idCliente);

                List<Pago> respuesta = conexionBD.selectList("pagos.obtenerPorClientes", parametros);
                if (respuesta != null) {
                    return respuesta; 
                } else {
                    
                    return new ArrayList<>(); 
                }
            } catch (Exception e) {
                e.printStackTrace(); 
            } finally {
                conexionBD.close(); 
            }
        } else {
            return new ArrayList<>();
        }
        return new ArrayList<>(); 
    }

}

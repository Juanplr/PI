package clientejavafx.modelo.dao;

import clientejavafx.modelo.ConexionWS;
import clientejavafx.utilidades.Constantes;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.util.List;
import pojo.RespuestaColaborador;
import pojo.RespuestaHTTP;
import pojo.RespuestaRol;
import pojo.Rol;

/**
 *
 * @author juanl
 */
public class RolDAO {
    public static List<Rol> optenerRoles(){
        List<Rol> roles = null;
        String url = Constantes.URL+"roles/optenerRoles";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if (respuesta.getCodigoRespuesta()==HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            try {
                //enviar una lista.
                //Type tipoListaColaborador = new TypeToken<List<Colaborador>>(){}.getType();
                RespuestaRol respuestaWS = gson.fromJson(respuesta.getContenido(), RespuestaRol.class);
                roles = respuestaWS.getRoles();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return roles;
    }
}

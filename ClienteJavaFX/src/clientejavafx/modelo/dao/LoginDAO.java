package clientejavafx.modelo.dao;

import clientejavafx.modelo.ConexionWS;
import clientejavafx.utilidades.Constantes;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import pojo.Login;
import pojo.RespuestaHTTP;

/**
 *
 * @author juanl
 */
public class LoginDAO {
    public static Login iniciarSesion(String noPersonal, String password){
        Login respuestaLogin = new Login();
        String url = Constantes.URL+"login/colaborador";
        String parametros = String.format("noPersonal=%s&password=%s", noPersonal,password);
        RespuestaHTTP respuestaWS = ConexionWS.peticionPOST(url, parametros);
        if(respuestaWS.getCodigoRespuesta()== HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            System.out.println("JSON: "  + respuestaWS.getContenido());
            respuestaLogin = gson.fromJson(respuestaWS.getContenido(), Login.class);
        }else{
            respuestaLogin.setError(true);
            respuestaLogin.setMensaje("Lo sentimos hubo un error de autentificación Intentalo más tarde");
        }
        return respuestaLogin;
    }
    
}

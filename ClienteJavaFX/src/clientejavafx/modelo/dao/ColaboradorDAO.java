/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejavafx.modelo.dao;

import clientejavafx.modelo.ConexionWS;
import clientejavafx.utilidades.Constantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;
import pojo.Colaborador;
import pojo.RespuestaColaborador;
import pojo.RespuestaHTTP;

/**
 *
 * @author juanl
 */
public class ColaboradorDAO {
    public static List<Colaborador> obtenerColaboradores(){
        List<Colaborador> colaboradores = null;
        String url = Constantes.URL+"colaborador/obtenerColaboradores";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if (respuesta.getCodigoRespuesta()==HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            try {
                RespuestaColaborador respuestaWS = gson.fromJson(respuesta.getContenido(), RespuestaColaborador.class);
                colaboradores = respuestaWS.getColaboradores();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return colaboradores;
    }
}

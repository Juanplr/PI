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
import pojo.Mensaje;
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
                //enviar una lista.
                //Type tipoListaColaborador = new TypeToken<List<Colaborador>>(){}.getType();
                RespuestaColaborador respuestaWS = gson.fromJson(respuesta.getContenido(), RespuestaColaborador.class);
                colaboradores = respuestaWS.getColaboradores();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return colaboradores;
    }
    
    public static Mensaje registrarColaborador(Colaborador colaborador){
        Mensaje msj = new Mensaje();
        String url = Constantes.URL + "colaborador/registrar";
        Gson gson = new Gson();
        try {
            String parametros = gson.toJson(colaborador);
            RespuestaHTTP respuesta = ConexionWS.peticionPOSTJSON(url, parametros);
            if(respuesta.getCodigoRespuesta()== HttpURLConnection.HTTP_OK){
                msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
            }else{
                msj.setError(true);
                msj.setMensaje(respuesta.getContenido());
            }
        } catch (Exception e) {
            msj.setError(true);
            msj.setMensaje(e.getMessage());
        }
        
        return msj;
    }
    public static Mensaje editarColaborador(Colaborador colaborador){
        Mensaje msj = new Mensaje();
        String url = Constantes.URL + "colaborador/editarColaborador";
        Gson gson = new Gson();
        try {
            String parametros = gson.toJson(colaborador);
            RespuestaHTTP respuesta = ConexionWS.peticionPUTJSON(url, parametros);
            if(respuesta.getCodigoRespuesta()== HttpURLConnection.HTTP_OK){
                msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
            }else{
                msj.setError(true);
                msj.setMensaje(respuesta.getContenido());
            }
        } catch (Exception e) {
            msj.setError(true);
            msj.setMensaje(e.getMessage());
        }
        
        return msj;
    }
    public static Mensaje eliminarColaborador(String noPersonal){
        Mensaje msj = new Mensaje();
        String url = Constantes.URL + "colaborador/eliminarColaborador";
        Gson gson = new Gson();
        try {
            String parametros = String.format("noPersonal=%s", noPersonal);
            RespuestaHTTP respuesta = ConexionWS.peticionDELETE(url, parametros);
            if(respuesta.getCodigoRespuesta()== HttpURLConnection.HTTP_OK){
                msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
            }else{
                msj.setError(true);
                msj.setMensaje(respuesta.getContenido());
            }
        } catch (Exception e) {
            msj.setError(true);
            msj.setMensaje(e.getMessage());
        }
        
        return msj;
    }
}

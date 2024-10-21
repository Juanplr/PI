/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author juanl
 */
public class ResultadoOperacion {
    
    private boolean error;
    private String tipoOperacion;
    private float resultado;

    public ResultadoOperacion(boolean error, String tipoOperacion, float resultado) {
        this.error = error;
        this.tipoOperacion = tipoOperacion;
        this.resultado = resultado;
    }

    public ResultadoOperacion() {
    }
    
    public boolean isError() {
        return error;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public float getResultado() {
        return resultado;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }
}

package operaciones;

import pojo.ResultadoOperacion;

/**
 *
 * @author juanl
 */
public class ImpOperaciones {
    
    public static ResultadoOperacion sumar(float numero1, float numero2){
        ResultadoOperacion resultado = new ResultadoOperacion();
        resultado.setError(false);
        resultado.setResultado(numero1+numero2);
        resultado.setTipoOperacion("suma");
        return resultado;
    }
    public static ResultadoOperacion restar(float numero1, float numero2){
        ResultadoOperacion resultado = new ResultadoOperacion();
        resultado.setError(false);
        resultado.setResultado(numero1-numero2);
        resultado.setTipoOperacion("resta");
        return resultado;
    }
    public static ResultadoOperacion multiplicar(float numero1, float numero2){
        ResultadoOperacion resultado = new ResultadoOperacion();
        resultado.setError(false);
        resultado.setResultado(numero1*numero2);
        resultado.setTipoOperacion("multiplicación");
        return resultado;
    }
    public static ResultadoOperacion dividir(float numero1, float numero2){
        ResultadoOperacion resultado = new ResultadoOperacion();
        resultado.setError(false);
        resultado.setResultado(numero1/numero2);
        resultado.setTipoOperacion("división");
        return resultado;
    }
    public static ResultadoOperacion modulo(float numero1, float numero2){
        ResultadoOperacion resultado = new ResultadoOperacion();
        resultado.setError(false);
        resultado.setResultado(numero1%numero2);
        resultado.setTipoOperacion("residuo");
        return resultado;
    }
    
    
    
    
}

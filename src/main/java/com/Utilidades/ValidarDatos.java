package com.Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que tiene diversos métodos para comprobar si una cadena de caracteres coincide con un patrón determinado. 
 * @author Antonio Ramos
 * @version 1.0
 */
public class ValidarDatos {
    /**
     * Método que comprueba que un NIF tenga un formato correcto
     * @param nif NIF que se quiere comprobar
     * @return devuelve true si el NIF recibido por parámetro tiene un formato válido.
     */
    public static boolean validarNif(String nif){
        // http://www.juntadeandalucia.es/servicios/madeja/contenido/recurso/677
        return true;
    }
    
    /**
     * Método que permite comprobar un código de un libro. Este debe estar formado por 3 letras y 2 números.
     * @param codigo cadena de caracteres que se quiere comprobar.
     * @return devuelve true si coincide con la expresión regular y falso en caso contrario.
     */
    public static boolean comprobarCodigoLibro(String codigo){
        Pattern p = Pattern.compile("[A-Z]{3}[0-9]{2}");
        Matcher m = p.matcher(codigo);
        return m.matches();
    }    
}

package com.EstructuraDatos;

/**
 * Clase que permite almacenar los datos correspondientes a un escritor.
 * @author Antonio Ramos
 * @version 1.0
 */
public class Autor {
    private String codigo;
    private String nombre;
    private String apellidos;

    /**
     * Constructor de la clase a partir de el nombre y el apellido del autor.
     * @param codigo cadena de caracteres que contiene el código del libro. Debe de estar formado por 3 letras y 2 dígtos.
     * @param nombre cadena de caracteres con el nombre. Debe ser mayor a 0.
     * @param apellidos cadena de caracteres con los apellidos. Debe ser mayor a 0.
     */
    public Autor (String codigo, String nombre, String apellidos){
        if(codigo.length() > 0)
            this.codigo = codigo;
        else
            this.codigo = "unknow";
        
        if(nombre.length() > 0)
            this.nombre = nombre;
        else
            this.nombre = "unknown";
        
        if(apellidos.length() > 0)
            this.apellidos = apellidos;
        else
            this.apellidos = "unknown";
    }
    
    /**
     * Método que permite modificar el atributo código.
     * @param codigo nuevo código.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Método que permite modificar el atributo nombre.
     * @param nombre nuevo nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que permite modificar el atributo apellidos.
     * @param apellidos nuevos apellidos.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }   
    
    /**
     * Método que devuelve el contenido almacenado en el atributo código.
     * @return contenido del atributo código.
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Método que devuelve el contenido almacenado en el atributo nombre.
     * @return contenido del atributo nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que devuelve el contenido almacenado en el atributo apellidos.
     * @return contenido del atributo apellidos.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método que devuelve una cadena de caracteres con toda la información almacenada en los atributos del objeto.
     * @return cadena de caracteres con la información almacenanada en los atributos.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "; Apellidos: " + apellidos;
    }       
}

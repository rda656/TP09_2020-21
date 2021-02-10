package com.Controlador;

import com.EstructuraDatos.*;
import com.Utilidades.*;

/**
 *
 * @author Antonio Ramos
 */
public class GestionBiblioteca {
    private static final int TAMLIBROS = 10;
    private static final int TAMAUTORES = 10;
    private static Libro[] libros;
    private static Autor[] autores;
        
    /**
     * Método que instancia los arrays
     * 
     */
    public static void inicializar() {
        libros = new Libro[TAMLIBROS];
        autores = new Autor[TAMAUTORES];
        
        autores[0] = new Autor("CB01", "Carmen", "de Burgos");
        autores[1] = new Autor("BF01", "Benito Jerónimo", "Feijoo");
        autores[2] = new Autor("FG01", "Federico", "García Lorca");
        autores[3] = new Autor("TM01", "Tomás", "Moro");
        
        libros[0] = new Libro("TEA01", "Teatro universal", 3);
        libros[1] = new Libro("BOD01", "Bodas de sangre", 2, autores[2]);
        libros[2] = new Libro("YER01", "Yerma", 10, autores[2]);
        
        //gestionMenuPrincipal();
    }
    
    /**
     * Método que muestra todos los elementos almacenados en el array libros
     * @return devuelve true si hay algún libro almacenado en el array y false en caso contrario.
     */
    /*private static boolean mostrarTodosLosLibros(){
        if(libros[0] == null)
            return false;
        
        for(int i = 0; i < libros.length; i++){
            if(libros[i] != null)
                System.out.println(libros[i].toString());
            else
                break;
        }
        return true;        
    }*/
    
    /**
     * Método que permite mostrar la información de un libro del array.
     * @return devuelve true si hay algún libro almacenado en el array y false en caso contrario.
     */
    public static Libro registroLibro(int posicion){
        if(posicion >= 0 && posicion < libros.length)
            return libros[posicion];
        else
            return null;
    }
     
    /**
     * Método que devuelve el array libros
     * @return array de libros
     */
    public static Libro[] todosRegistrosLibros(){
        return libros;
    }
    
    /**
     * Método que devuelve la última posición del array que contiene datos.
     * @return última posición del array con datos.
     */
    public static int posicionUltimoRegistroLibros(){
        for (int i = 0; i < libros.length; i++){
            if(libros[i] == null)
                return i - 1;
        }
        
        return libros.length - 1;
    }
    
    
    /**
     * Muestra un menú con los nombres de los libros.
     * @return Devuelve el número de registros que ha sido capaz de mostrar.
     */
    private static int mostarMenuNombreLibros(){
        for(int i = 0; i < libros.length; i++){
            if(libros[i] != null)
                System.out.println((i+1) + ". " + libros[i].getNombre());
            else
                return i;
        }
        return libros.length;
    }
    
    /**
     * Método que permite añadir un libro al array.
     * @return devuelve false si el array no tiene más capacidad para almacenar libros.
     */
    private static boolean aniadirLibro(){
        for(int i = 0; i < libros.length; i++){
            if(libros[i] == null){
                String codigo;
                do{
                    codigo = ES.leerCadena("Introduzca el código del libro (recuerde que debe de estar formado por 3 letras seguidas de 2 números): ");
                    codigo = codigo.toUpperCase();
                    if(!ValidarDatos.comprobarCodigoLibro(codigo))
                        System.err.println("Error. El código introducido no es válido");
                }while(!ValidarDatos.comprobarCodigoLibro(codigo));
                
                libros[i] = new Libro(codigo, ES.leerCadena("Introduzca el nombre del libro: "), ES.leerEntero("Introduzca el número de ejemplares que hay del libro: "));
                return true;       
            }
        }
        return false;
    }
    
    /**
     * Método que permite eliminar un registro del array
     * @return devuelve true si se ha podido realizar el borrado y false si no hay registros almacenados.
     */
    private static boolean eliminarLibro(){
        int numeroLibros = mostarMenuNombreLibros();
        if(numeroLibros == 0)
            return false;
        
        int opcion = ES.leerEntero(0, numeroLibros, "0. Salir.\n Elija una opción: ");
        
        for(; opcion < libros.length; opcion++){            
            libros[opcion-1] = libros[opcion];
            
            if (libros[opcion] == null)
                return true;
        }
        libros[libros.length-1] = null;
        return true;
    }
    
    /**
     * Método que permite devolver un ejemplar de un libro.
     * @return devuelve true si se ha podido realizar la devolución y false si no hay registros almacenados.
     */
    private static boolean devolverLibro(){
        int numeroLibros = mostarMenuNombreLibros();
        if(numeroLibros == 0)
            return false;
        
        int opcion = ES.leerEntero(0, numeroLibros, "0. Salir.\n Elija una opción: ");
        
        libros[opcion-1].devolverEjemplar();        
        return true;
    }
    
    /**
     * Método que permite devolver un ejemplar de un libro.
     * @return devuelve true si se ha podido realizar el préstamo y false si no hay registros almacenados.
     */
    private static boolean prestarLibro(){
        int numeroLibros = mostarMenuNombreLibros();
        if(numeroLibros == 0)
            return false;
        
        int opcion = ES.leerEntero(0, numeroLibros, "0. Salir.\n Elija una opción: ");
        
        libros[opcion-1].prestarEjemplar();        
        return true;
    }
    
    /**
     * Método que permite modificar un ejemplar de un libro.
     */
    public static void modificarLibro(int posicion, String nombre, int unidades){
        libros[posicion].setNombre(nombre);
        libros[posicion].setUnidades(unidades);        
    }
    
    /**
     * Método que permite modificar un ejemplar de un libro.
     */
    public static void modificarLibro(int posicion, String nombre, int unidades, Autor autor){
        libros[posicion].setNombre(nombre);
        libros[posicion].setUnidades(unidades);
        libros[posicion].setAutor(autor);
    }
    
    /**
     * Método que permite mostrar la información de un autor del array.
     * @return devuelve un registro si hay algún autor almacenado en el array y 
     * null en caso de que la posición sea errónea o no exista un registro en dicha posición.
     */
    public static Autor registroAutor(int posicion){
        if(posicion >= 0 && posicion < autores.length)
            return autores[posicion];
        else
            return null;
    }
    
    public static Autor[] todosRegistrosAutores(){
        return autores;
    }
}

package com.Controlador;

import com.EstructuraDatos.*;
import com.Utilidades.*;

/**
 *
 * @author Antonio Ramos
 */
public class GestionBiblioteca {
    private static Libro[] libros;
    private static Autor[] autores;
        
    /**
     * Método que instancia los arrays
     * 
     */
    public static void inicializar() {
        libros = new Libro[10];
        autores = new Autor[10];
        
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
    public static Libro mostrarLibro(int posicion){
        if(posicion >= 0 && posicion < libros.length)
            return libros[posicion];
        else
            return null;
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
     * Método que permite devolver un ejemplar de un libro.
     * @return devuelve true si se ha podido realizar la devolución y false si no hay registros almacenados.
     */
    private static boolean modificarLibro(){
        int parametroModificar, numeroLibros = mostarMenuNombreLibros();
        if(numeroLibros == 0)
            return false;
        
        int opcion = ES.leerEntero(0, numeroLibros, "0. Salir.\n Elija una opción: ");
        
        do{
            parametroModificar = ES.leerEntero(opcion, opcion, "¿Qué parámetro quiere modificar?\n"
                    + "1. Nombre.\n"
                    + "2. Unidades.\n"
                    + "0. Salir.\n"
                    + "Elija una opción: ");
            switch(parametroModificar){
                case 0:
                    System.out.println("Volviendo al menú de libros...");
                    break;
                case 1:
                    libros[opcion - 1].setNombre(ES.leerCadena("Introduzca el nuevo nombre: "));
                    break;
                case 2:
                    libros[opcion - 1].setUnidades(ES.leerEntero("Introduzca el número de unidades que hay del libro: "));
                    break;
            }
        }while(parametroModificar != 0);
        
        return true;
    }
}

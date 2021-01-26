package com.EstructuraDatos;

/**
 *  Clase que permite almacenar los datos de un libro.
 * @author Antonio Ramos
 * @version 1.0
 */
public class Libro {
    private String codigo;
    private String nombre;
    private Autor autor;
    private int unidades;
    private int unidadesPrestadas;

    /**
     * Constructor de la clase a partir de datos para los diferentes atributos.
     * @param codigo código del libro. Debe ser 3 letras seguidas de 2 números.
     * @param nombre nombre del libro.
     * @param autor autor del libro.
     * @param unidades cantidad de ejemplares que hay de un libro. Ha de ser mayor o igual 0.
     */
    public Libro(String codigo, String nombre, Autor autor, int unidades) {
        this.nombre = nombre;
        this.autor = autor;
        if (unidades < 0) {
            this.unidades = 0;
        } else {
            this.unidades = unidades;
        }
    }
    
    /**
     * Constructor de la clase.
     * @param codigo código del libro. Debe ser 3 letras seguidas de 2 números.
     * @param nombre nombre del libro.
     * @param unidades cantidad de ejemplares que hay de un libro. Ha de ser mayor o igual 0.
     */
    public Libro(String codigo, String nombre, int unidades) {
        this.nombre = nombre;
        if (unidades < 0) {
            this.unidades = 0;
        } else {
            this.unidades = unidades;
        }
        
        autor = null;
    }

    /**
     * Método que devuelve el código del libro.
     * @return código del libro
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método que devuelve el nombre del libro.
     * @return nombre del libro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que modifica el nombre de un libro.
     * @param nombre nuevo nombre del libro.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el autor del libro.
     * @return autor del libro
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * Método que modifica el autor de un libro.
     * @param autor nuevo autor del libro.
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * Método que devuelve las unidades que hay del libro.
     * @return unidades del libro
     */
    public int getUnidades() {
        return unidades;
    }

    /**
     * Método que modifica las unidades de un libro.
     * @param unidades unidades que hay de un libro. Ha de ser igual o mayor que 0.
     */
    public void setUnidades(int unidades) {
        if(unidades >= 0)
            this.unidades = unidades;
    }

    /**
     * Método que devuelve una cadena de caracteres con toda la información almacenada en los atributos del objeto.
     * @return cadena de caracteres con la información almacenanada en los atributos.
     */
    @Override
    public String toString() {
        String toStringAutor;
        if(autor == null)
            toStringAutor = "";
        else
            toStringAutor = autor.toString();
        return "Libro:" + "\ncódigo: " + codigo + "\nnombre: " + nombre + "\nunidades:" + unidades 
                + "\nunidades prestadas: " + unidadesPrestadas + "\n" + toStringAutor;
    }

    /**
     * Método que permite prestar un ejemplar. Cada vez que se llame incrementará en una unidad el atributo
     * unidadesPrestadas, hasta llegar al máximo de unidades que se tiene.
     */
    public void prestarEjemplar() {
        if(unidadesPrestadas != unidades)
            unidadesPrestadas++;
        else
            System.out.println("Todas los ejemplares se han prestado");
    }

    /**
     * Método que descuenta un ejemeplar del atributo unidadesPrestadas cada vez que es llamado.
     * Si unidadesPrestadas vale 0 no descontará ninguna unidad.
     */
    public void devolverEjemplar() {
        if(unidadesPrestadas > 0)
            unidadesPrestadas--;
        else
            System.out.println("Todas los ejemplares están en la biblioteca");
    }

    /**
     * Método que devuelve cuantas unidades hay prestadas.
     * @return unidades prestadas.
     */
    public int ejemplaresDisponibles() {
        return unidadesPrestadas;
    }
}

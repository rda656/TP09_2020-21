package com.Vista;

import com.Controlador.App;
import com.Controlador.GestionBiblioteca;
import com.EstructuraDatos.Autor;
import com.EstructuraDatos.Libro;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;

public class GUIPrincipal implements Initializable{
    
    private static int posicionAutores = 0;
    private static int posicionLibros = 0;
    
    @FXML
    private TabPane panelPrincipal;

    @FXML
    private Tab subLibros, subAutores;
        
    @FXML
    private ToolBar panelInferior;

    @FXML
    private TextField tf_LibroCodigo, tf_LibroNombre, tf_LibroANombre, tf_LibroAApellidos, tf_LibroUnidades,
            tf_LibroACodigo, tf_LibroPrestados, tf_AutorNombre, tf_AutorApellidos, tf_AutorCodigo, tf_NumRegistro;

    @FXML
    private Button btn_Primero, btn_Anterior, btn_Siguiente, btn_Ultimo, btn_Anadir, btn_Modificar, btn_Eliminar, btn_Guardar, btn_Cancelar;

    /**
     * Método que se ejecuta una vez inicializada la interfaz gráfica
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenarCamposLibro(GestionBiblioteca.registroLibro(posicionLibros));
    }

    /**
     * Método que devuelve la posición de los datos que se están mostrando del array de autores 
     * @return posición del arrray de autores
     */
    public static int getPosicionAutores() {
        return posicionAutores;
    }

    /**
     * Método que devuelve la posición de los datos que se están mostrando del array de autores 
     * @return posición del arrray de autores
     */
    public static int getPosicionLibros() {
        return posicionLibros;
    }
        
    /**
     * Método que permite cerrar la aplicación
     * @param event 
     */
    @FXML
    private void cerrar(ActionEvent event) {
        Platform.exit();
    }
    
    /**
     * Método que permite ir al primer registro guardado en el array libros o en el array autores
     * @param event 
     */
    @FXML
    void primerRegistro(ActionEvent event) {
        if(pestaniaActual().equals("Libros")){
            //Libro libro = GestionBiblioteca.mostrarLibro(0);
            //rellenarCamposLibro(libro);
            posicionLibros = 0;
            rellenarCamposLibro(GestionBiblioteca.registroLibro(posicionLibros));
        }
        else{
            System.out.println("Estoy en autores");
        }
            
    }
    
    /**
     * Método que permite ir al registro anterior guardado en el array libros o en el array autores
     * @param event 
     */
    @FXML
    private void anteriorRegistro(ActionEvent event) {
        movimientoRegistro(-1);
    }
    
    /**
     * Método que permite ir al registro siguiente guardado en el array libros o en el array autores
     * @param event 
     */
    @FXML
    void siguienteRegistro(ActionEvent event) {
        movimientoRegistro(1);
    }

    /**
     * Método que permite ir al último registro guardado en el array libros o en el array autores
     * @param event 
     */
    @FXML
    void ultimoRegistro(ActionEvent event) {
        if(pestaniaActual().equals("Libros")){
            posicionLibros = GestionBiblioteca.posicionUltimoRegistroLibros();

            Libro libro = GestionBiblioteca.registroLibro(posicionLibros);
            if(libro != null){
                rellenarCamposLibro(libro);
            }
        }
        else{
            System.out.println("Estoy en autores");
        }
    }
    
    /**
     * Método que activa los botones de guardar y modificiar, y desactiva el resto. De igual modo permite la edición
     * de los diferentes campos de texto (text field).
     * @param event 
     */
    /*@FXML
    void modificarRegistro(ActionEvent event) {
        btn_Guardar.setDisable(false);
        btn_Cancelar.setDisable(false);
                
        btn_Primero.setDisable(true);
        btn_Anterior.setDisable(true);
        btn_Siguiente.setDisable(true);
        btn_Ultimo.setDisable(true);
        btn_Modificar.setDisable(true);
                
        
        if(pestaniaActual().equals("Libros")){           
            tf_LibroNombre.setEditable(true);
            tf_LibroUnidades.setEditable(true);
            //tf_LibroPrestados.setEditable(true);
        }
        else{
            System.out.println("Estoy en autores");
        }
    }*/
    
    @FXML
    private void modificarRegistro(ActionEvent event) throws IOException {
        if(pestaniaActual().equals("Libros")){
            App.setRoot("ModificarLibro");
        }
        else{
            System.out.println("Estoy en autores");
        }
        
    }
    
    @FXML
    void guardarRegistro(ActionEvent event) {
        if(pestaniaActual().equals("Libros")){
            GestionBiblioteca.modificarLibro(posicionLibros, tf_LibroNombre.getText(), Integer.parseInt(tf_LibroUnidades.getText()));
            estadoInicialElementosGUI();
        }
        else{
            System.out.println("Estoy en autores");
        }
    }
    
    /**
     * Cancela la acción de modificar los datos de un registro.
     * @param event 
     */
    @FXML
    void cancelarModificacionRegistro(ActionEvent event) {
        estadoInicialElementosGUI();                
    }
    
    /**
     * Método que devuelve el nombre de la pestaña actual en la que nos encontramos
     * @return nombre de la pestaña actual
     */
    private String pestaniaActual(){
        return panelPrincipal.getSelectionModel().getSelectedItem().getText();
    }
    
    /**
     * Método que rellena los distintos campos de la GUI a partir de los datos de un libro
     * @param libro objeto con el que rellenar los campos de la GUI
     */
    private void rellenarCamposLibro(Libro libro){
        if(libro != null){
            btn_Modificar.setDisable(false);
            
            tf_NumRegistro.setText("" + posicionLibros);
            
            tf_LibroCodigo.setText(libro.getCodigo());
            tf_LibroNombre.setText(libro.getNombre());
            tf_LibroUnidades.setText("" + libro.getUnidades());
            tf_LibroPrestados.setText("" + libro.getUnidadesPrestadas());

            if(libro.getAutor() != null){
                Autor autor = libro.getAutor();
                tf_LibroACodigo.setText(autor.getCodigo());
                tf_LibroANombre.setText(autor.getNombre());
                tf_LibroAApellidos.setText(autor.getApellidos());
            }
            else{
                tf_LibroACodigo.setText("");
                tf_LibroANombre.setText("");
                tf_LibroAApellidos.setText("");
            }
        }
        else{
            btn_Modificar.setDisable(true);
        }
    }
    
    /**
     * Método que permite movernos a través de los registros almacenados en los arrays libros y autores
     * en función del incremento pasado por parámentro.
     * @param incremento cantidad que queremos desplazarnos en el array
     */
    private void movimientoRegistro(int incremento){
        if(pestaniaActual().equals("Libros")){
                       
            Libro libro = GestionBiblioteca.registroLibro(posicionLibros + incremento);
            if(libro != null){
                posicionLibros += incremento;
                rellenarCamposLibro(libro);
            }
        }
        else{
            System.out.println("Estoy en autores");
        }
    }


    /**
     * Método que activa los distintos botones que permiten el desplazamiento y desactiva la edición de los diferentes campos de texto.
     */
    private void estadoInicialElementosGUI(){
        btn_Guardar.setDisable(true);
        btn_Cancelar.setDisable(true);
                
        btn_Primero.setDisable(false);
        btn_Anterior.setDisable(false);
        btn_Siguiente.setDisable(false);
        btn_Ultimo.setDisable(false);
        btn_Modificar.setDisable(false);
                
        
        if(pestaniaActual().equals("Libros")){
            tf_LibroNombre.setEditable(false);
            tf_LibroUnidades.setEditable(false);
           // tf_LibroPrestados.setEditable(false);
            
            movimientoRegistro(0);
        }
        else{
            System.out.println("Estoy en autores");
        } 
    }
}

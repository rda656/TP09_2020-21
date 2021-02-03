package com.Vista;

import com.Controlador.GestionBiblioteca;
import com.EstructuraDatos.Autor;
import com.EstructuraDatos.Libro;
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
    
    private int posicionAutores = 0;
    private int posicionLibros = 0;
    
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
    private Button btn_Primero, btn_Anterior, btn_Siguiente, btn_Ultimo, btn_Anadir, btn_Modificar, btn_Eliminar;

    @FXML
    private void cerrar(ActionEvent event) {
        Platform.exit();
    }
    
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
    
    @FXML
    private void anteriorRegistro(ActionEvent event) {
        
    }
    

    @FXML
    void siguienteRegistro(ActionEvent event) {
        if(pestaniaActual().equals("Libros")){
                       
            Libro libro = GestionBiblioteca.registroLibro(posicionLibros + 1);
            if(libro != null){
                posicionLibros++;
                rellenarCamposLibro(libro);
            }
        }
        else{
            System.out.println("Estoy en autores");
        }
    }

    @FXML
    void ultimoRegistro(ActionEvent event) {

    }
    
    private String pestaniaActual(){
        return panelPrincipal.getSelectionModel().getSelectedItem().getText();
    }
    
    private void rellenarCamposLibro(Libro libro){
        if(libro != null){
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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenarCamposLibro(GestionBiblioteca.registroLibro(posicionLibros));
    }
}


package com.Vista;

import com.Controlador.App;
import com.Controlador.GestionBiblioteca;
import com.EstructuraDatos.Autor;
import com.EstructuraDatos.Libro;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class GUIModificarLibro  implements Initializable{
    @FXML
    private TextField tf_LibroCodigo, tf_LibroNombre, tf_LibroUnidades;

    @FXML
    private ListView l_autores;

    @FXML
    void cancelarModificacionRegistro(ActionEvent event) throws IOException {
        App.setRoot("Principal");
    }

    @FXML
    void guardarRegistro(ActionEvent event) throws IOException {
        GestionBiblioteca.modificarLibro(
                GUIPrincipal.getPosicionLibros(),               // Posición del libro que queremos modificar
                tf_LibroNombre.getText(),                       // Nuevo nombre
                Integer.parseInt(tf_LibroUnidades.getText()),   // Nueva cantidad de unidades
                (Autor) l_autores.getSelectionModel().getSelectedItem()); // Autor seleccionado
        
        App.setRoot("Principal");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenarLista();
        rellenarCamposDeTexto();
    }
    
    private void rellenarLista() {
        Autor[] autores = GestionBiblioteca.todosRegistrosAutores();

        for (Autor a : autores) {
            if (a != null) {
                l_autores.getItems().add(a);
            }
        }
        l_autores.getItems().add(null);
    }
    
    private void rellenarCamposDeTexto(){
        Libro libro = GestionBiblioteca.registroLibro(GUIPrincipal.getPosicionLibros());
        
        if(libro != null){
            
            tf_LibroCodigo.setText(libro.getCodigo());
            tf_LibroNombre.setText(libro.getNombre());
            tf_LibroUnidades.setText("" + libro.getUnidades());
            
            if(libro.getAutor() == null)
                l_autores.getSelectionModel().selectLast();
            else{
                Autor[] autores = GestionBiblioteca.todosRegistrosAutores();
                
                for(int i = 0; i < autores.length; i++){
                    if(libro.getAutor().equals(autores[i])){
                        l_autores.getSelectionModel().select(i);
                        break;
                    }
                        
                }
            }
        }
        
    }
}

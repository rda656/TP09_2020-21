package com.Vista;

import com.Controlador.GestionBiblioteca;
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

public class GUIPrincipal  implements Initializable{
    
     @FXML
    private TabPane panelPrincipal;

    @FXML
    private Tab subLibros, subAutores;
        
    @FXML
    private ToolBar panelInferior;

    @FXML
    private TextField tf_LibroCodigo, tf_LibroNombre, tf_LibroANombre, tf_LibroAApellidos, tf_LibroUnidades,
            tf_LibroACodigo, tf_LibroPrestados, tf_AutorNombre, tf_AutorApellidos, tf_AutorCodigo, textNumRegistro;

    @FXML
    private Button btn_Primero, btn_Anterior, btn_Siguiente, btn_Ultimo, btn_Anadir, btn_Modificar, btn_Eliminar;

    @FXML
    private void cerrar(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GestionBiblioteca.inicializar();
    }
}

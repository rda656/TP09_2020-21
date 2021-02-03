package com.Vista;

import com.Controlador.GestionBiblioteca;
import com.EstructuraDatos.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GUIEjemploLista implements Initializable {

    @FXML
    private ListView list_Libros;

    @FXML
    private TableView tv_Libros;

    private void rellenarLista() {
        Libro[] libros = GestionBiblioteca.todosRegistrosLibros();

        for (Libro l : libros) {
            if (l != null) {
                list_Libros.getItems().add(l);
            }
        }
    }

    private void crearColumnasTabla() {
        TableColumn colCodigo = new TableColumn("Código");
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        TableColumn colNombre = new TableColumn("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        TableColumn colUnidades = new TableColumn("Unidades");
        colUnidades.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        
        TableColumn colUdPrestadas = new TableColumn("Ud. Prestadas");
        colUdPrestadas.setCellValueFactory(new PropertyValueFactory<>("unidadesPrestadas"));
        
        tv_Libros.getColumns().addAll(colCodigo, colNombre, colUnidades, colUdPrestadas);
        
    }

    private void rellenarTabla(){
        Libro[] libros = GestionBiblioteca.todosRegistrosLibros();

        for (Libro l : libros) {
            if (l != null) {
                tv_Libros.getItems().add(l);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenarLista();
        crearColumnasTabla();
        rellenarTabla();
    }
}

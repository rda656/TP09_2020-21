package com.Controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static String ruta = "/com/vista/";

    @Override
    public void start(Stage stage) throws IOException {
        GestionBiblioteca.inicializar();

        scene = new Scene(loadFXML(ruta + "Principal"));
        //scene = new Scene(loadFXML("/com/vista/EjemploLista")); 

        stage.setTitle("Gestión Biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(ruta + fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
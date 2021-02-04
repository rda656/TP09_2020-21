module com.Controlador {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.Vista to javafx.fxml;
    exports com.Controlador;
    exports com.EstructuraDatos;
}

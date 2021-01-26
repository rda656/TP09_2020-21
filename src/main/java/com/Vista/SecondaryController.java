package com.Vista;

import com.Controlador.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("/com/vista/Principal");
    }
}
package com.Vista;

import com.Controlador.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class GUIPrincipal {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("/com/vista/secondary");
    }
}

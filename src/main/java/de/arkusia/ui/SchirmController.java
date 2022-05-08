package de.arkusia.ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class SchirmController
{

    @FXML
    BorderPane schirm;
    public SchirmController()
    {

    }

    public void mitteEinfuegen(Parent root)
    {
        Platform.runLater(()->schirm.setCenter(root));
    }
}

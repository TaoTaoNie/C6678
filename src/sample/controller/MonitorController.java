package sample.controller;

import javafx.fxml.Initializable;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author leetHuam
 * @version 1.0
 */
public class MonitorController implements Initializable {
    private Main main;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMain(Main main) {
        this.main = main;
    }
}

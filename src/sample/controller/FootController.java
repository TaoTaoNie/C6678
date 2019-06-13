package sample.controller;

import javafx.fxml.Initializable;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author leetHuam
 * @version 1.0
 */
public class FootController implements Initializable {

    private Main mainApp;

    /**
     * 初始化的方法，创建对象时会调用这个方法
     * @param location 不知道
     * @param resources 不知道
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * 将 main insert进来
     * @param mainApp main
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
}

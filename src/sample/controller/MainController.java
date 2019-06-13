package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import sample.Main;
import sample.util.CopyFile;
import sample.util.RetentionFileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author leetHuam
 * @version 1.0
 */
public class MainController implements Initializable {
    @FXML
    private AnchorPane pane;

    @FXML
    private SplitPane splitPane;

    @FXML
    private Label sourceFile;

    @FXML
    private Label confFile;

    @FXML
    private Label sourceIma;


    @FXML
    private Button sourceFileButt;

    @FXML
    private Button confButt;

    @FXML
    private Button sourceImaButt;


    private Main mainApp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * 拿到需要分割和合成代码，自动拆分和代码
     */
    @FXML
    private void handleChooseSourceFile() {
        File chooseFile = RetentionFileChooser.showOpenDialog(mainApp.primaryStage, "选择源程序文件",
                RetentionFileChooser.FilterMode.C_FILES);
    }

    /**
     * 拿到 xml 格式的配置文件用于自动分割和合成代码
     */
    @FXML
    private void handleChooseConfigureFile() {
        File chooseFile = RetentionFileChooser.showOpenDialog(mainApp.primaryStage, "选择配置文件",
                RetentionFileChooser.FilterMode.XML_FILES);
    }

    /**
     * 拿到需要处理的图片，仅支持 bmp 格式的图片
     */
    @FXML
    private void handleChooseSourceImage() {
        File chooseFile = RetentionFileChooser.showOpenDialog(mainApp.primaryStage, "选择处理图片",
                RetentionFileChooser.FilterMode.BMP_FILES);
        //将用户选取的图片复制到项目目录下面，用来展示图片
        String src = chooseFile.getAbsolutePath();
        String target = ".\\src\\images_input\\input.bmp";
        CopyFile.copyFile(src, target);
    }

    public void setMainApp(Main main) {
        mainApp = main;
    }
}

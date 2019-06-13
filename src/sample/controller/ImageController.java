package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.Main;
import sample.util.Commons;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author leetHuam
 * @version 1.0
 */
public class ImageController implements Initializable {
    @FXML
    private ImageView imagePreProcess;

    private Main main;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label label;

    public boolean pre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(Main main) {
        this.main = main;
    }

    public void setPre(boolean pre) {
        this.pre = pre;
    }

    /**
     * 显示图片
     */
    public void show() {
        if (pre) {
            label.setText("处理前图片");
            imagePreProcess.setImage(new Image(Commons.inputImagePath));
        } else {
            label.setText("处理后图片");
            imagePreProcess.setImage(new Image(Commons.outputImagePath));
        }
    }
}

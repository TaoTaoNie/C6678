package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author leetHuam
 * @version 1.0
 */
public class RootController implements Initializable {
    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem preProcess;

    private Main main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        menuBar.prefWidthProperty().bind(pane.widthProperty());
    }

    /**
     * 显示处理之前的图片
     */
    @FXML
    public void showPreProcessPic() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("./view/image.fxml"));
            AnchorPane imagePane = (AnchorPane) loader.load();

            main.root.setCenter(imagePane);

            ImageController controller = loader.getController();
            controller.setMainApp(main);
            controller.setPre(true);
            controller.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示处理之后的图片
     */
    @FXML
    public void showPostProcessPic() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("./view/image.fxml"));
            AnchorPane imagePane = (AnchorPane) loader.load();

            main.root.setCenter(imagePane);

            ImageController controller = loader.getController();
            controller.setMainApp(main);
            controller.setPre(false);
            controller.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void returnHome() {
        main.root.setCenter(main.fileChooseView);
    }

    /**
     * 显示内存监控
     */
    @FXML
    public void monitorCache() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("./view/monitor.fxml"));
            AnchorPane monitorPane = (AnchorPane) loader.load();

            main.root.setCenter(monitorPane);

            MonitorController controller = loader.getController();
            controller.setMain(main);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setMain(Main main) {
        this.main = main;
    }

}

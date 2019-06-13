package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.controller.FootController;
import sample.controller.MainController;
import sample.controller.RootController;

import java.io.IOException;

public class Main extends Application {

    public Stage primaryStage;
    public BorderPane root;
    public AnchorPane fileChooseView;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        primaryStage.setTitle("多核DSP-C6678客户端");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("./resources/icon.png")));
//        primaryStage.show();

        initRootLayout();
        showFileChooseView();
        showFootView();
    }

    /**
     * 初始化刚开始的界面
     */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("./view/root.fxml"));

            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 1000, 800);
            primaryStage.setScene(scene);
            primaryStage.show();

            RootController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * 开始的主要的界面
     */
    public void showFileChooseView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("./view/main.fxml"));
            fileChooseView = (AnchorPane) loader.load();

            root.setCenter(fileChooseView);

            MainController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFootView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("./view/foot.fxml"));
            Pane footPane = (Pane) loader.load();

            root.setBottom(footPane);

            FootController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

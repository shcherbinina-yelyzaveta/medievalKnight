package com.company.game;

import com.company.game.controller.CharacterViewController;
import com.company.game.controller.ShopViewController;
import com.company.game.controller.StorageViewController;
import com.company.game.model.Armor;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import com.company.game.model.Knight;

import java.io.IOException;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private Knight character;
    private ObservableList<Armor> armors = FXCollections.observableArrayList();
    private ObservableList<Armor> storageArmors = FXCollections.observableArrayList();

    public MainApp() {
        this.character = new Knight();
        this.armors.add(new Armor("Железный меч", 50, 10, 0,
                new Image(MainApp.class.getResource("/images/1.png").toExternalForm())));
        this.armors.add(new Armor("Стальной меч", 100, 15, 0,
                new Image(MainApp.class.getResource("/images/2.png").toExternalForm())));
        this.armors.add(new Armor("Секира", 160, 17, 0,
                new Image(MainApp.class.getResource("/images/3.png").toExternalForm())));
        this.armors.add(new Armor("Имперский меч", 200, 18, 0,
                new Image(MainApp.class.getResource("/images/4.png").toExternalForm())));
        this.armors.add(new Armor("Железный щит", 100, 0, 15,
                new Image(MainApp.class.getResource("/images/18.png").toExternalForm())));
        this.armors.add(new Armor("Щит цветной", 100, 0, 15,
                new Image(MainApp.class.getResource("/images/19.png").toExternalForm())));
        this.armors.add(new Armor("Щит улучшенный", 200, 0, 20,
                new Image(MainApp.class.getResource("/images/20.png").toExternalForm())));
        this.armors.add(new Armor("Щит премиум", 350, 0, 30,
                new Image(MainApp.class.getResource("/images/21.png").toExternalForm())));
    }

    public Knight getCharacter() {
        return character;
    }

    private Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Armor> getArmors() {
        return armors;
    }

    public ObservableList<Armor> getStorageArmors() {
        return storageArmors;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Средневековый рыцарь");
        this.primaryStage.getIcons().add(new Image(MainApp.class.getResource("/images/11.png").toExternalForm()));

        initRootLayout();
        showCharacterView();
    }


    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/RootLayout.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            Media sound = new Media(MainApp.class.getResource("/audio/1.mp3").toExternalForm());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setVolume(0.2);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCharacterView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/CharacterView.fxml"));
            AnchorPane characterView = loader.load();

            rootLayout.setCenter(characterView);
            CharacterViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showShopView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/ShopView.fxml"));
            AnchorPane shopView = loader.load();

            rootLayout.setCenter(shopView);
            ShopViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStorageView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/StorageView.fxml"));
            AnchorPane shopView = loader.load();

            rootLayout.setCenter(shopView);
            StorageViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAlert(Alert.AlertType type, String content) {
        Alert alert = new Alert(type);
        alert.initOwner(getPrimaryStage());
        alert.setTitle("Средневековый рыцарь");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.getDialogPane().setPrefWidth(250);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

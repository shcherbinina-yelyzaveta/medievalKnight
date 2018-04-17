package com.company.game.controller;

import com.company.game.MainApp;
import com.company.game.model.Armor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class StorageViewController {
    @FXML
    private Label name;
    @FXML
    private Label attack;
    @FXML
    private Label protection;
    @FXML
    private Label price;
    @FXML
    private TableView<Armor> tableView;
    @FXML
    private TableColumn<Armor, String> tableColumn;
    @FXML
    private ImageView mainImageView;

    private MainApp mainApp;

    public StorageViewController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tableView.setItems(mainApp.getStorageArmors());
    }

    private void showProductDetails(Armor armor) {
        if (armor != null) {
            mainImageView.setImage(armor.getImage());
            mainImageView.setFitHeight(100);
            mainImageView.setFitWidth(124);
            mainImageView.setVisible(true);
            name.setText(armor.getName());
            attack.setText("+" + armor.getAttack());
            protection.setText("+" + armor.getProtection());
            price.setText(armor.getPrice() + " монет");
        } else {
            name.setText("");
            attack.setText("");
            protection.setText("");
            price.setText("");
        }
    }

    @FXML
    private void initialize() {
        tableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showProductDetails(null);

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showProductDetails(newValue));
    }

    @FXML
    private void handleClothe() {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            mainApp.getCharacter().clothe(mainApp.getStorageArmors().get(selectedIndex));
        }
    }

    @FXML
    private void handleHome() {
        mainApp.showCharacterView();
    }

    @FXML
    private void handleStore() {
        mainApp.showShopView();
    }

    @FXML
    private void handleStock() {

    }
}

package com.company.game.controller;

import com.company.game.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class CharacterViewController {
    @FXML
    private Label attack;
    @FXML
    private Label protection;
    @FXML
    private Label cash;
    @FXML
    private ImageView protectionElement;
    @FXML
    private ImageView attackElement;

    private MainApp mainApp;

    public CharacterViewController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        attack.setText(mainApp.getCharacter().getAttack() + "");
        protection.setText(mainApp.getCharacter().getProtection() + "");
        cash.setText(mainApp.getCharacter().getCash() + "");
        protectionElement.setImage(mainApp.getCharacter().getProtectionArmor().getImage());
        attackElement.setImage(mainApp.getCharacter().getAttackArmor().getImage());
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleHome() {
    }

    @FXML
    private void handleStore() {
        mainApp.showShopView();
    }

    @FXML
    private void handleStock() {
        mainApp.showStorageView();
    }
}

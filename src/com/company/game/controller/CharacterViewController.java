package com.company.game.controller;

import com.company.game.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CharacterViewController {
    @FXML
    private Label attach;
    @FXML
    private Label protection;
    @FXML
    private Label cash;

    private MainApp mainApp;

    public CharacterViewController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        attach.setText(mainApp.getCharacter().getAttack() + "");
        protection.setText(mainApp.getCharacter().getProtection() + "");
        cash.setText(mainApp.getCharacter().getCash()+"");
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

    }
}

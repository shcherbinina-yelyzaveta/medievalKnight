package com.company.game.controller;

import com.company.game.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ShopViewController {
    @FXML
    private Label name;
    @FXML
    private Label attach;
    @FXML
    private Label protection;
    @FXML
    private Label price;

    private MainApp mainApp;

    public ShopViewController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        name.setText("Имя");
        attach.setText("+10");
        protection.setText("+5");
        price.setText("50 монет");
    }

    @FXML
    private void initialize(){
    }
}

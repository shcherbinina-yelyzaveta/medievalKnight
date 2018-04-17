package com.company.game.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Alert;

public class Knight {
    private IntegerProperty attack;
    private IntegerProperty protection;
    private IntegerProperty cash;
    private Armor attackArmor;
    private Armor protectionArmor;

    public Knight() {
        attack = new SimpleIntegerProperty(10);
        protection = new SimpleIntegerProperty(10);
        cash = new SimpleIntegerProperty(1000);
        attackArmor = new Armor();
        protectionArmor = new Armor();
    }

    public int getAttack() {
        return attack.get();
    }

    public IntegerProperty attackProperty() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack.set(attack);
    }

    public int getProtection() {
        return protection.get();
    }

    public IntegerProperty protectionProperty() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection.set(protection);
    }

    public int getCash() {
        return cash.get();
    }

    public IntegerProperty cashProperty() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash.set(cash);
    }

    public Armor getAttackArmor() {
        return attackArmor;
    }

    public Armor getProtectionArmor() {
        return protectionArmor;
    }

    private void addAttach(Armor armor) {
        this.attack = new SimpleIntegerProperty(getAttack() + armor.getAttack());
    }

    private void addProtection(Armor armor) {
        this.protection = new SimpleIntegerProperty(getProtection() + armor.getProtection());
    }

    private void deductAttach(Armor armor) {
        this.attack = new SimpleIntegerProperty(getAttack() - armor.getAttack());
    }

    private void deductProtection(Armor armor) {
        this.protection = new SimpleIntegerProperty(getProtection() - armor.getProtection());
    }

    public void buy(Armor armor) {
        this.cash = new SimpleIntegerProperty(getCash() - armor.getPrice());
    }

    public void clothe(Armor armor) {
        if (attackArmor.equals(armor) || protectionArmor.equals(armor)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Средневековый рыцарь");
            alert.setHeaderText(null);
            alert.setContentText("Вы уже одели " + armor.getName());
            alert.getDialogPane().setPrefWidth(250);
            alert.showAndWait();
        } else {
            if (armor.getAttack() != 0) {
                deductAttach(attackArmor);
                attackArmor = armor;
                addAttach(armor);
            } else {
                deductProtection(protectionArmor);
                protectionArmor = armor;
                addProtection(armor);
            }
        }
    }
}

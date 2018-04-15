package com.company.game.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Knight {
    private IntegerProperty attack;
    private IntegerProperty protection;
    private IntegerProperty cash;

    public Knight() {
        attack = new SimpleIntegerProperty(10);
        protection = new SimpleIntegerProperty(10);
        cash = new SimpleIntegerProperty(1000);
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
}

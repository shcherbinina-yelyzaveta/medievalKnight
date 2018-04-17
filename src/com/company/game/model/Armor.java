package com.company.game.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Armor {
    private StringProperty name;
    private IntegerProperty price;
    private IntegerProperty attack;
    private IntegerProperty protection;
    private Image image;

    public Armor() {
        name = new SimpleStringProperty("");
        price = new SimpleIntegerProperty(0);
        attack = new SimpleIntegerProperty(0);
        protection = new SimpleIntegerProperty(0);
    }

    public Armor(String name, int price, int attack, int protection, Image image) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.attack = new SimpleIntegerProperty(attack);
        this.protection = new SimpleIntegerProperty(protection);
        this.image = image;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getPrice() {
        return price.get();
    }

    public IntegerProperty priceProperty() {
        return price;
    }

    public void setPrice(int price) {
        this.price.set(price);
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armor)) return false;

        Armor armor = (Armor) o;

        if (getName() != null ? !getName().equals(armor.getName()) : armor.getName() != null) return false;
        if (priceProperty() != null ? !priceProperty().equals(armor.priceProperty()) : armor.priceProperty() != null)
            return false;
        if (attackProperty() != null ? !attackProperty().equals(armor.attackProperty()) : armor.attackProperty() != null)
            return false;
        if (priceProperty() != null ? !priceProperty().equals(armor.priceProperty()) : armor.priceProperty() != null)
            return false;
        return getImage() != null ? getImage().equals(armor.getImage()) : armor.getImage() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (priceProperty() != null ? priceProperty().hashCode() : 0);
        result = 31 * result + (attackProperty() != null ? attackProperty().hashCode() : 0);
        result = 31 * result + (priceProperty() != null ? priceProperty().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        return result;
    }
}

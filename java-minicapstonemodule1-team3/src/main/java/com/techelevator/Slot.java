package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Slot {

    String line = Files.readAllLines(Paths.get(new VendingMachine().getFilePath())).get(1);
    String[] str = line.split("\\|");

    //    INSTANCE VARIABLES
    private String slotPosition = str[0];
    private String name = str[1];
    private BigDecimal price = new BigDecimal(str[2]);
    private String animalName = str[3];
    private int quantity = 5;

    //  Constructors
    public Slot(String[] str) throws IOException {
        this.slotPosition = str[0];
        this.name = str[1];
        this.price = new BigDecimal(str[2]);
        this.animalName = str[3];
    }

    //
    public Slot() throws IOException {
    }

    //    GETTERS AND SETTERS

    public String getSlotPosition() {
        return slotPosition;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

}
//    TODO make a dispense item method


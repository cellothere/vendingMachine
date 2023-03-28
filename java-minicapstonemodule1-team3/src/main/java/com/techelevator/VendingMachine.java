package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class VendingMachine {

//    INSTANCE VARIABLES
    private String filePath = "vendingmachine.csv";
    private File vendingFile = new File(filePath);
    Scanner scanner = new Scanner(System.in);
    private boolean isOn = true;
    private Slot[] slotArray = new Slot[16];

//    TODO get the line length of the file being read, use this to determine array length

//    create constructors to instantiate new vending machines, create a second constructor in case the vending machine is off.
    public VendingMachine(){
    }

    public VendingMachine(boolean isOn){
        this.isOn = true;
    }

//    GETTERS AND SETTERS

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean trueOrFalse) {
        this.isOn = trueOrFalse;
    }

    public String getFilePath(){
        return filePath;
    }

//   Set up a new slot array to hold the arrays from the file
    public Slot[] getSlotArray() throws IOException {

//        Create a getter for other classes to instantiate Slot[] array
        Slot[] slots = new Slot[16];
        try (Scanner fileScanner = new Scanner(vendingFile)) {
            for (int i = 0; i < slotArray.length; i++) {

                String line = fileScanner.nextLine();

//                separate each line into a new array, separated at the pipe symbol
                String[] str = line.split("\\|");
                Slot newSlot = new Slot(str);
                slots[i] = newSlot;
            }
            return slots;
        } catch (IOException e){
            System.out.println("Cannot read file");
        } return null;
    }

//    run the vending machine
    public void runVendingMachine() throws IOException {

        if (isOn) {
//        Display the main menu for the user and get their response
            int mainMenuOptionSelected = new MainMenu().getMainMenu();

//        if the mainMenuOptionSelected is 1, then the console should display the inventory
            if (mainMenuOptionSelected == 1) {

                try (Scanner fileScanner = new Scanner(vendingFile)) {
                    int i = 0;
                    while (fileScanner.hasNextLine()) {

                        String line = fileScanner.nextLine();
                        String[] str = line.split("\\|");
                        Slot newSlot = new Slot(str);
                        slotArray[i] = newSlot;
                        System.out.println(slotArray[i].getSlotPosition() + " " + " " + slotArray[i].getName() + " " + " " + slotArray[i].getPrice());
                        i++;
                    }
//                if the user selected 1, they should be prompted to the main screen again
                    System.out.println();
                    new VendingMachine().runVendingMachine();
                }
                catch (FileNotFoundException e) {
                    System.out.println("File not found");
                }
            }

//        if the user selects 2 from the main menu, they should be brought to the purchase menu class
            else if (mainMenuOptionSelected == 2) {

                new PurchaseAnItem().purchaseAnItem();

            }
//            if they select three, exit the program
            if (mainMenuOptionSelected == 3) {
                System.exit(1);
            }
        }

//        if the vending machine is off, turn it an and rerun the program
        else if(!isOn){
            System.out.println("Please press 1 to turn on vending machine");
            String turnVendingOn = scanner.nextLine();
            if(turnVendingOn.equals("1")){
                VendingMachine vendingMachine = new VendingMachine(true);
                vendingMachine.runVendingMachine();
            }
        }
    }
}




package com.techelevator;

import java.util.Scanner;

public class MainMenu {

    public int userResponse = 0;

//    Getter for user response
    public int getUserResponse(){
        return userResponse;
    }

    public int getMainMenu() {

//            Display main menu to the user
            System.out.println(" Welcome to the VendoMatic! gIve ME yER money!!!");
            System.out.println("(" + 1 + ")" + " Display Vending Machine Items");
            System.out.println("(" + 2 + ")" + " Purchase");
            System.out.println("(" + 3 + ")" + " Exit");

            Scanner scanner = new Scanner(System.in);

//            Store the user's main menu selection, make sure the number is an int
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Please enter a 1, 2, or 3");
        }
            int userResponse = scanner.nextInt();

        return userResponse;
    }
}


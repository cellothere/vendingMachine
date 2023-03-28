package com.techelevator;

public class CalculateChange {

//class should take in a change amount already converted to an int in the vending machine class
    public String calCoins(int change) {

        int quarters = 0;
        int nickles = 0;
        int dimes = 0;

        while (change > 0) {
            while (change >= 25) {
                quarters = quarters + 1;
                change = change - 25;
            }
            while (change >= 10) {
                dimes = dimes + 1;
                change = change - 10;
            }
            while (change >= 5) {
                nickles = nickles + 1;
                change = change - 5;
            }
        }
        return (quarters + " quarters " + dimes + " dimes " + nickles + " nickles ");
    }

}









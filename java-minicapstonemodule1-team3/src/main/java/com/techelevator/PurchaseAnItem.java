package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class PurchaseAnItem extends VendingMachine {

//INSTANCE VARIABLES
    private Slot[] slotArray = super.getSlotArray();
    private Date date = new Date();
    private int intChange = 0;
    private BigDecimal change;
    private BigDecimal userMoney = new BigDecimal(0);

//    CONSTRUCTORS
    public PurchaseAnItem() throws IOException {
    }

//   open file and printWriter
    File inputFile = new File("log.txt");
    PrintWriter dataOutput = new PrintWriter(inputFile);
    Scanner scanner = new Scanner(System.in);

//  Method to return an int depending on the user's response
    public int makeSelection(){

//     Display purchase menu
        System.out.println("1) Feed Money\n2) Select Product\n3) Finish Transaction");

//        get the user's choice and parse to an int
        int userResponse = Integer.parseInt(scanner.nextLine());
        return userResponse;

    }


    public void purchaseAnItem() throws IOException {

//        check that the input file exits, else, no file found
        if (inputFile.exists()) {

//            Loop this until the user decides to exit
            while (true) {

//                use the purchase menu to select the desired option, then store that option as an int
                int userPurchaseOption = makeSelection();

//                    if the user selects 3 from the purchase menu, exit the program
                if (userPurchaseOption == 3) {

                    System.out.println(new CalculateChange().calCoins(intChange));
                    System.out.println("Take you change and your item. THANK YOU!");

                    break;
                }
                else if (userPurchaseOption == 1) {

                    System.out.println("How many bills do you want to enter: ");
                    BigDecimal billsEntered = BigDecimal.valueOf(Integer.parseInt(scanner.nextLine()));
                    userMoney = billsEntered.add(userMoney);


                    System.out.println("Current credits available: " + "$" + userMoney);
                }
                else if (userPurchaseOption == 2) {

//                Print out full inventory, update inventory after every purchase, string userSelection to hold the user's selection
                    String userSelection = "";

                    for (int i = 0; i < slotArray.length; i++) {

                        System.out.println(slotArray[i].getSlotPosition() + " " + " " + slotArray[i].getName() + " " + " " + slotArray[i].getPrice() + " " + "Quantity: " + slotArray[i].getQuantity());
                    }
                    System.out.println("\nPlease make selection: ");
                    userSelection = scanner.nextLine();

//                                Compare the user's selection to how much money they have
                    for (int i = 0; i < slotArray.length; i++) {
                        if (userSelection.equals(slotArray[i].getSlotPosition())) {

                            if (userMoney.compareTo(slotArray[i].getPrice()) == -1) {
                                System.out.println("Please enter more money");
                                break;
                            }
                        }


                        if (slotArray[i].getSlotPosition().equals(userSelection)) {

                            if(slotArray[i].getQuantity() == 0){
                                System.out.println("This item is out of stock, please make a different selection: \n");
                            }

                            else if(slotArray[i].getQuantity() > 0) {

                                slotArray[i].setQuantity(slotArray[i].getQuantity() - 1);

                                //                              Calculate difference between userMoney and item price
                                change = userMoney.subtract(slotArray[i].getPrice());

                                //                               Turn the big decimal into an int * 100
                                intChange = change.multiply(BigDecimal.valueOf(100)).intValueExact();

                                //                                Subtract the price from the user money
                                userMoney = userMoney.subtract(slotArray[i].getPrice());

                                //                            Return the change and userMoney to the user
                                System.out.println("You have $" + userMoney + " remaining.");

                                dataOutput.println(date);

                            }
                            break;
                        }
                    }

                }

            }

        }
    }
}

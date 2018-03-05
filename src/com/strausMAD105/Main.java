package com.strausMAD105;


import java.util.Scanner;

/**
 *  inheritance assignment MAD105
 */
public class Main {

    /**
     * The main method prompts user for type of client, commercial or residential
     * includes methods for specific client data entered by user
     * @param args generates and calls classes for a landscaping business
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int input = 0;
//------------- Main Menu

        try {// ----------- TRY to CATCH InputMismatchException from user input
            while (input == 0) {
                    System.out.println("1.) For Commercial property: ");
                    System.out.println("2.) For Residential property: ");
                    System.out.println("3.) Done");
                    System.out.println("\nPlease enter a number between 1 and 3:");
                    int pick = keyboard.nextInt();
                switch (pick) {
                        case 1:
                            commercialClient();  //---------- Assign object variable to method commercial
                            input = 1;//------------- Increment input to break while loop
                            break;
                        case 2:
                            residentialClient();  //---------- Assign object variable to method residential
                            input = 1;  //------------- Increment input to break while loop
                            break;
                        case 3:
                            System.out.println("End of program!");
                            input = 1;
                            break;
                        default:
                            System.out.println("Please enter a number between 1 and 3:");
                    }//---End switch pick
            }//-----End while
        } catch (Exception e) {
            System.out.println("Caught InputMismatchException in method main");
            System.out.println("Click on the green arrow on left to re-start");
            //------- END of Try/Catch
        }


    } //---END method main

    // ------------------ User input for commercial

    /**
     *  a void method that gets client specifics for a commercial client.
     *  object variable client assigned to commercial class which calculates charges and displays invoice
     */

    public static void commercialClient(){
        Boolean multi;
        String discount;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("COMMERCIAL CUSTOMER");
        System.out.print("Enter customer name: ");
        String name = keyboard.nextLine();
        System.out.print("Enter billing address: ");
        String address = keyboard.nextLine();
        System.out.println("Enter phone number");
        String phone = keyboard.next();
        try {// ----------- TRY to CATCH InputMismatchException from user input
            do {
                System.out.print("Does this account have more than one property under contract? (y or n)");
                discount  = keyboard.next();
            }while (!discount.equalsIgnoreCase("y") && !discount.equalsIgnoreCase("n"));
            if (discount.equalsIgnoreCase("y")){// ----- raeds String input and ignores case sensitivity
                multi = true; // boolean for discount
            }
            else {
                multi = false;
            }
            System.out.println("Enter the full name of the primary property on the contract: ");
            String propertyName = keyboard.next();
            System.out.print("Enter the total area under contract in sq.ft.: ");
            double totalArea = keyboard.nextDouble();
            Commercial client = new Commercial(name, address, phone, multi, propertyName, totalArea); // -- new class object
            client.calculateWeekly();//--- calculate and display
            System.out.println("\nEnd of program - Commercial");
        } catch (Exception e) {
            System.out.println("Caught InputMismatchException in commercialClient");
            System.out.println("Click on the green arrow on left to re-start");
        }//------- END of Try/Catch


    }// --------- END public method commercialClient()

    /**
     * a void method that gets client specifics for a residential client.
     *  object variable client assigned to commercial class which calculates charges and displays invoice
     */
    public static void residentialClient(){
        Boolean multi;
        String quote;
        String discount;
        int whichType;
        Scanner keyboard = new Scanner(System.in);

        try {// ----------- TRY to CATCH InputMismatchException from user input
            System.out.println("RESIDENTIAL CUSTOMER");
            System.out.println("Enter customer name: ");
            String name = keyboard.nextLine();
            System.out.print("Enter customer address: ");
            String address = keyboard.nextLine();
            System.out.println("Enter phone number");
            String phone = keyboard.next();
            do {
                System.out.println("1.) Prepare a quote");
                System.out.println("2.) Prepare an invoice");
                whichType = keyboard.nextInt();
            } while (whichType != 1 && whichType != 2);
            if(whichType == 1){
                quote = "QUOTE";
            }
            else {
                quote = "INVOICE";
            }
            do {
                System.out.print("Does the customer qualify for a Senior Citizen Discount? (y or n)");
                discount = keyboard.next();
            }while (!discount.equalsIgnoreCase("y") && !discount.equalsIgnoreCase("n"));
            if (discount.equalsIgnoreCase("y")){
                multi = true;
            }
            else {
                multi = false;
            }
            System.out.print("Enter the total area under contract in sq.ft.: ");
            double totalArea = keyboard.nextDouble();
            Residential client = new Residential(name, address, phone, multi, totalArea, quote);
            client.calculateWeekly();
            System.out.println("\nEnd of program - Residential");
        } catch (Exception e) {
            System.out.println("Caught InputMismatchException in residentialClient");
            System.out.println("Click on the green arrow on left to re-start");
        }//------- END of Try/Catch

    }// --------- END public method residentialClient()


}//-----END CLASS MAIN

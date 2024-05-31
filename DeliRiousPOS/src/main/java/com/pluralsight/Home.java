package com.pluralsight;

import java.util.*;
import java.io.IOException;

public class Home
{
    public static void main(String[] args) throws IOException
    {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Time to get Delirious! ");
        System.out.println("Home of the most euphoric sandwiches!");
        System.out.println();
        System.out.println("What would you like to do?");

        while (true)
        {
            System.out.println("[1] New Order");
            System.out.println("[2] Quit");
            System.out.println();
            System.out.println("Please enter your selection here:");
            String choice = scanner.nextLine();

            switch (choice)
            {
                case "1":
                    OrderScreen orderMenu = new OrderScreen();
                    orderMenu.run();
                    break;
                case "2":
                    System.out.println("Thanks for visiting!");
                    System.exit(0);
                default:
                    System.out.println("Invalid entry. Please try again");
                    break;

            }
        }
    }
}
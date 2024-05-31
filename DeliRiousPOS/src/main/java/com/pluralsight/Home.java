package com.pluralsight;

import java.util.*;
import java.io.IOException;

public class Home
{
    public static void main(String[] args) throws IOException
    {
        final Scanner scanner = new Scanner(System.in);

        System.out.println(Colors.BRIGHT_YELLOW + "Time to get Delirious! " + Colors.TEXT_RESET);
        System.out.println(Colors.BRIGHT_CYAN + "Home of the most euphoric sandwiches!" + Colors.TEXT_RESET);
        System.out.println();
        System.out.println(Colors.YELLOW + "What would you like to do?" + Colors.TEXT_RESET);

        while (true)
        {
            System.out.println(Colors.BRIGHT_WHITE + "[1] New Order");
            System.out.println("[2] Quit" + Colors.TEXT_RESET);
            System.out.println();
            System.out.println("Please enter your selection here: ");
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
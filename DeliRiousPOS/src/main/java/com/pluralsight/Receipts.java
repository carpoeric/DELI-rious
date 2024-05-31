package com.pluralsight;

import java.time.format.DateTimeFormatter;
import java.io.*;
import java.time.*;
public class Receipts
{


    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
    String formatDateTime = now.format(formatter);
    String filePath = "src/main/resources/"+formatDateTime;


    public void write (Order order)throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
        writer.write("This order was placed on " + formatDateTime);
        writer.newLine();
        int counter = 1;
        for(Sandwich sandwich: order.sandwiches)
        {
            writer.newLine();
            writer.write("Sandwich " + String.valueOf(counter) +"\n" + " Size: " +
                    String.valueOf(sandwich.getSize()) + " inches " + "\n" + "Bread: " +
                    sandwich.getBread() + "\n" + " Meat(s): " + sandwich.displayMeat() +"\n" + " Cheese(s): "
                    + sandwich.displayCheese() + "\n" + " Vegetable(s): " + sandwich.displayVeg() + "\n" + " Sauce(s): "
                    + sandwich.displaySauce() + "\n" + " Side(s): " + sandwich.displaySides()+ "\n"  + "\n" );
            counter++;
            writer.newLine();
        }
        for(String drinks :order.drinks)
        {
            writer.write("Drink: " + drinks + "\n");

        }
        for(String chips : order.chips)
        {
            writer.write("Chips: " + chips + "\n");
        }
        writer.write("Order Total: $" + String.format("%.2f",order.getTotal()));
        writer.close();
    }

}
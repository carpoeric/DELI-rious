package com.pluralsight;

import java.util.ArrayList;

public class Order
{
    private double total;
    ArrayList<Sandwich> sandwiches;
    ArrayList<String> drinks, chips;

    ArrayList<SignatureSandwiches> signatureSandwiches;

    public Order()
    {
        this.total = 0;
        this.sandwiches = new ArrayList<Sandwich>();
        this.drinks = new ArrayList<String>();
        this.chips = new ArrayList<String>();
        this.signatureSandwiches = new ArrayList<SignatureSandwiches>();

    }

    public double getTotal()
    {
        return total;
    }


    public void addSandwich(Sandwich sandwich)
    {
        sandwiches.add(sandwich);
    }

    public void setDrinkChipTotal(double amount)
    {
        this.total += amount;
    }

    public void setSandwichPrices()
    {
        for(Sandwich sandwich : sandwiches)
        {
            this.total += sandwich.getTotalPrice();
        }
    }
}


package com.pluralsight;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

class OrderScreen
{
    public static Order createOrder = new Order();
    private ArrayList<String> createSandwich;
    private ArrayList<String> drinks;
    private ArrayList<String> chips;
    private double totalPrice;


    public OrderScreen()
    {
        this.createSandwich = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.totalPrice = 0.00;
    }

    public void run() throws IOException
    {
        System.out.println(Colors.BRIGHT_YELLOW + "What are we feelin' today?" + Colors.TEXT_RESET);
        while (true)
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.println();
            System.out.println(Colors.YELLOW + "Order Options:" + Colors.TEXT_RESET);
            System.out.println(Colors.BRIGHT_WHITE + "[1] Add a sandwich");
            System.out.println("[2] Add a drink");
            System.out.println("[3] Add chippies");
            System.out.println("[4] Checkout time!");
            System.out.println("[0] Actually... Cancel this order." + Colors.TEXT_RESET);
            System.out.println();
            System.out.println("Please enter your selection here: ");
            String choice = keyboard.nextLine();

            switch (choice)
            {
                case "1":
                    System.out.println();
                    System.out.println(Colors.YELLOW + "What kind of sandwich would you like?");
                    System.out.println(Colors.BRIGHT_WHITE + "[1] Give me a SIGNATURE!");
                    System.out.println("[2] I'll freestyle it. (CUSTOM)" + Colors.TEXT_RESET);
                    System.out.println();
                    System.out.println("Please enter your selection here: ");
                    int order = keyboard.nextInt();

                    int counter = 1;
                    if (order == 1)
                    {
                        System.out.println();
                        System.out.println(Colors.BRIGHT_GREEN + "Here's a list of our Signature Sandwiches!" + Colors.TEXT_RESET);
                        System.out.println();
                        SignatureSandwiches signatureSandwich = new SignatureSandwiches();

                        for (Sandwich sandwich : signatureSandwich.signatureSandwiches)
                        {

                            System.out.println(Colors.BRIGHT_WHITE + "[" + counter + "]" + sandwich.getDescription() + Colors.TEXT_RESET);
                            System.out.println();
                            counter++;
                        }

                        System.out.println("What option would you like? Please enter your selection here: ");
                        int customerChoice = keyboard.nextInt();
                        keyboard.nextLine();

                        switch (customerChoice)
                        {
                            case 1:
                                createOrder.addSandwich(signatureSandwich.signatureSandwiches.get(0));
                                printSandwichAndSetPrice();
                                break;
                            case 2:
                                createOrder.addSandwich(signatureSandwich.signatureSandwiches.get(1));
                                printSandwichAndSetPrice();
                                break;
                            case 3:
                                createOrder.addSandwich(signatureSandwich.signatureSandwiches.get(2));
                                printSandwichAndSetPrice();
                                break;
                            case 4:
                                createOrder.addSandwich(signatureSandwich.signatureSandwiches.get(3));
                                printSandwichAndSetPrice();
                                break;
                            case 5:
                                createOrder.addSandwich(signatureSandwich.signatureSandwiches.get(4));
                                printSandwichAndSetPrice();
                                break;
                            default:
                                System.out.println("INVALID");
                        }
                    }

                    else
                    {
                        System.out.println();
                        System.out.println(Colors.YELLOW + "We currently offer sandwich sizes in: " + Colors.TEXT_RESET);
                        System.out.println(Colors.BRIGHT_WHITE + "[4] 4 Inches");
                        System.out.println("[8] 8 Inches");
                        System.out.println("[12] 12 Inches" + Colors.TEXT_RESET);
                        System.out.println();
                        System.out.println("What sandwich size would you like? Please enter your selection here (Just the number!): ");
                        int size = keyboard.nextInt();
                        keyboard.nextLine();

                        System.out.println(Colors.YELLOW + "We currently offer these choices of bread: " + Colors.TEXT_RESET);
                        System.out.println(Colors.BRIGHT_WHITE + "[White]");
                        System.out.println("[Wheat]");
                        System.out.println("[Rye]");
                        System.out.println("[Wraps]" + Colors.TEXT_RESET);
                        System.out.println();
                        System.out.println("What kind of bread would you prefer? Please enter your selection here: ");
                        String bread = keyboard.nextLine().trim();
                        System.out.println();
                        System.out.println(Colors.YELLOW + "Do you want your bread nice and toasty? (Yes/No)" + Colors.TEXT_RESET);
                        System.out.println("Please enter your selection here: ");
                        String option = keyboard.nextLine().trim();
                        boolean bool;
                        if (option.equalsIgnoreCase("Yes"))
                        {
                            bool = true;
                        }

                        else
                        {
                            bool = false;
                        }

                        boolean extraMeat;
                        boolean extraCheese;

                        List<String> meatToppings =
                                Arrays.asList("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Mushroom", "Bacon", "Move on to cheese...");
                        List<String> cheeseToppings =
                                Arrays.asList("American", "Provolone", "Cheddar", "Swiss", "Move on to veggies...");
                        List<String> vegToppings =
                                Arrays.asList("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms", "Move on to sauces...");
                        List<String> sauceToppings =
                                Arrays.asList("Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette", "Halal Sauce", "Move on to sides...");
                        List<String> sideToppings =
                                Arrays.asList("Au Jus", "Extra Sauce" , "x");

                        Sandwich sandwich = new Sandwich(size, bread, bool);

                        int customerChoice = 0;
                        System.out.println();
                        System.out.println(Colors.YELLOW + "Would you like meat on your sandwich?" + Colors.TEXT_RESET);
                        System.out.println(Colors.BRIGHT_WHITE + "[1] Sure!");
                        System.out.println("[2] Not interested..." + Colors.TEXT_RESET);
                        System.out.println();
                        System.out.println("Please enter your selection here: ");
                        customerChoice = keyboard.nextInt();
                        keyboard.nextLine();

                        customerMeat(customerChoice, meatToppings, keyboard, sandwich);
                        customerCheese(keyboard, cheeseToppings, sandwich);
                        customerToppings(keyboard, vegToppings, sandwich);
                        customerSauces(keyboard, sauceToppings, sandwich);
                        customerSide(keyboard, sideToppings, sandwich);

                        addDisplaySandwich(sandwich);
                    }

                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkout();
                    break;
                case "0":
                    System.out.println("Redirecting to the home page now...");
                    return;
                default:
                    System.out.println("Invalid entry. Please try again.");
                    break;

            }
        }
    }

    private static void printSandwichAndSetPrice()
    {
        System.out.println();
        System.out.println(Colors.BRIGHT_CYAN + "Sandwich successfully added!" + Colors.TEXT_RESET);
        System.out.println();
        createOrder.setSandwichPrices();
    }

    private static void customerMeat(int customerChoice, List<String> meatToppings, Scanner keyboard, Sandwich sandwich)
    {
        if (customerChoice == 1)
        {
            int moreMeatToppings = 1;

            while (moreMeatToppings != 8)
            {
                if (moreMeatToppings <= 7)
                {
                    System.out.println();
                    System.out.println(Colors.YELLOW + "Here's our meat selection..." + Colors.TEXT_RESET);

                    for (int i = 1; i < meatToppings.size() + 1; i++)
                    {
                        System.out.println(Colors.BRIGHT_WHITE + "[" + i + "] " + meatToppings.get(i - 1) + Colors.TEXT_RESET);
                    }
                    System.out.println("Please enter your selection here: ");

                    moreMeatToppings = keyboard.nextInt();
                    keyboard.nextLine();
                    if (sandwich.meatToppings.size() > 1)
                    {
                        sandwich.extraMeat();
                    }
                    sandwich.meatToppings.add(meatToppings.get(moreMeatToppings - 1));
                }
                if (sandwich.meatToppings.contains("Move on to cheese..."))
                {
                    sandwich.meatToppings.remove(sandwich.meatToppings.size() - 1);
                }
                if (sandwich.meatToppings.isEmpty())
                {

                    sandwich.meatToppings.add("NO MEAT...");
                }
                else
                {
                    System.out.println(sandwich.meatToppings);

                }
            }
        }
    }


    private static void customerCheese(Scanner keyboard, List<String> cheeseToppings, Sandwich sandwich)
    {
        int customerChoice2 = 0;
        System.out.println();
        System.out.println(Colors.YELLOW + "Would you like cheese?" + Colors.TEXT_RESET);
        System.out.println(Colors.BRIGHT_WHITE + "[1] Yes");
        System.out.println("[2] No" + Colors.TEXT_RESET);
        System.out.println();
        System.out.println("Please enter your selection here: ");
        customerChoice2 = keyboard.nextInt();
        keyboard.nextLine();
        if (customerChoice2 == 1)
        {
            int moreCheeseToppings = 1;

            while (moreCheeseToppings != 5)
            {
                if (moreCheeseToppings <= 4)
                {
                    System.out.println();
                    System.out.println(Colors.YELLOW + "Here's our cheese options..." + Colors.TEXT_RESET);
                    for (int i = 1; i < cheeseToppings.size() + 1; i++)
                    {
                        System.out.println(Colors.BRIGHT_WHITE + "[" + i + "] " + cheeseToppings.get(i - 1) + Colors.TEXT_RESET);

                    }
                    System.out.println("Please enter your selection here: ");

                    moreCheeseToppings = keyboard.nextInt();
                    keyboard.nextLine();
                    if (sandwich.cheeseToppings.size() > 1)
                    {
                        sandwich.extraCheese();
                    }
                    sandwich.cheeseToppings.add(cheeseToppings.get(moreCheeseToppings - 1));
                }
                if (sandwich.cheeseToppings.contains("Move on to veggies..."))
                {
                    sandwich.cheeseToppings.remove(sandwich.cheeseToppings.size() - 1);
                }
                if (sandwich.cheeseToppings.isEmpty())
                {
                    sandwich.cheeseToppings.add("NO CHEESE...");
                }
                else
                {
                    System.out.println(sandwich.cheeseToppings);
                    System.out.println();
                }
            }
        }
    }

    private static void customerToppings(Scanner keyboard, List<String> vegToppings, Sandwich sandwich)
    {
        int customerChoice3 = 0;
        System.out.println();
        System.out.println(Colors.YELLOW + "Would you like vegetables on your sandwich?" + Colors.TEXT_RESET);
        System.out.println(Colors.BRIGHT_WHITE + "1: Yes");
        System.out.println("2: No" + Colors.TEXT_RESET);
        System.out.println();
        System.out.println("Please enter your selection here: ");
        customerChoice3 = keyboard.nextInt();
        keyboard.nextLine();
        if (customerChoice3 == 1)
        {
            int moreVegetableToppings = 1;

            while (moreVegetableToppings != 10)
            {
                if (moreVegetableToppings <= 9)
                {
                    System.out.println();
                    System.out.println(Colors.YELLOW + "Here's our veggies selection..." + Colors.TEXT_RESET);
                    for (int i = 1; i < vegToppings.size() + 1; i++)
                    {
                        System.out.println(Colors.BRIGHT_WHITE + "[" + i + "]" + vegToppings.get(i - 1) + Colors.TEXT_RESET);
                    }
                    System.out.println("Please enter your selection here: ");

                    moreVegetableToppings = keyboard.nextInt();
                    keyboard.nextLine();
                    sandwich.vegetableToppings.add(vegToppings.get(moreVegetableToppings - 1));
                }
                if (sandwich.vegetableToppings.contains("Move on to sauces..."))
                {
                    sandwich.vegetableToppings.remove(sandwich.vegetableToppings.size() - 1);
                }
                if (sandwich.vegetableToppings.isEmpty())
                {
                    sandwich.vegetableToppings.add("NO VEGGIES...");
                }
                else
                {

                    System.out.println(sandwich.vegetableToppings);
                }
            }
        }
    }

    private static void customerSauces(Scanner keyboard, List<String> sauceToppings, Sandwich sandwich)
    {
        int customerChoice4 = 0;
        System.out.println();
        System.out.println(Colors.YELLOW + "Would you like any sauces on your sandwich?" + Colors.TEXT_RESET);
        System.out.println(Colors.BRIGHT_WHITE + "[1] Yes");
        System.out.println("[2] No" + Colors.TEXT_RESET);
        System.out.println();
        System.out.println("Please enter your selection here: ");
        customerChoice4 = keyboard.nextInt();
        keyboard.nextLine();
        if (customerChoice4 == 1)
        {
            int moreSauceToppings = 1;

            while (moreSauceToppings != 8)
            {
                if (moreSauceToppings <= 7)
                {
                    System.out.println();
                    System.out.println(Colors.YELLOW + "Here's our sauce options..." + Colors.TEXT_RESET);
                    for (int i = 1; i < sauceToppings.size() + 1; i++)
                    {
                        System.out.println(Colors.BRIGHT_WHITE + "[" + i + "]" + sauceToppings.get(i - 1) + Colors.TEXT_RESET);
                    }
                    System.out.println("Please enter your selection here: ");

                    moreSauceToppings = keyboard.nextInt();
                    keyboard.nextLine();
                    sandwich.sauceToppings.add(sauceToppings.get(moreSauceToppings - 1));
                }
                if (sandwich.sauceToppings.contains("Move on to sides..."))
                {
                    sandwich.sauceToppings.remove(sandwich.sauceToppings.size() - 1);
                }
                if (sandwich.sauceToppings.size() < 1)
                {
                    sandwich.sauceToppings.add("NO SAUCES...");
                }
                else
                {
                    System.out.println(sandwich.sauceToppings);
                }
            }
        }
    }

    private static void customerSide(Scanner keyboard, List<String> sideToppings, Sandwich sandwich)
    {
        int customerChoice5 = 0;
        System.out.println();
        System.out.println(Colors.YELLOW + "Would you like any sides?" + Colors.TEXT_RESET);
        System.out.println(Colors.BRIGHT_WHITE + "[1] Sure!");
        System.out.println("[2] Not interested..." + Colors.TEXT_RESET);
        System.out.println();
        System.out.println("Please enter your selection here: ");
        customerChoice5 = keyboard.nextInt();
        keyboard.nextLine();
        if (customerChoice5 == 1)
        {
            int moreSideToppings = 1;

            while (moreSideToppings != 3)
            {
                if (moreSideToppings <= 2)
                {
                    System.out.println();
                    System.out.println(Colors.YELLOW + "Here's our sides..." + Colors.TEXT_RESET);
                    for (int i = 1; i < sideToppings.size() + 1; i++)
                    {
                        System.out.println(Colors.BRIGHT_WHITE + "[" + i + "]" + sideToppings.get(i - 1) + Colors.TEXT_RESET);
                    }
                    System.out.println("Please enter your selection here: ");

                    moreSideToppings = keyboard.nextInt();
                    keyboard.nextLine();
                    sandwich.sideToppings.add(sideToppings.get(moreSideToppings - 1));
                }
                if (sandwich.sideToppings.isEmpty())
                {
                    sandwich.sideToppings.add("NO SIDES...");
                }
                else
                {
                    System.out.println(sandwich.sideToppings);
                    System.out.println();
                }
            }
        }

        if (sandwich.sideToppings.contains("NO SIDES AVAILABLE..."))
        {
            sandwich.sideToppings.remove(sandwich.sideToppings.size() - 1);
        }
    }

    private void addDrink()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(Colors.BRIGHT_GREEN + "Please select the size of your drink:" + Colors.TEXT_RESET);
        System.out.println(Colors.BRIGHT_WHITE + "[1] Small");
        System.out.println("[2] Medium");
        System.out.println("[3] Large" + Colors.TEXT_RESET);
        System.out.print("Please enter your selection here: ");

        String sizeChoice = keyboard.nextLine();
        Map<String, Double> drinkPrices = new HashMap<>();

        drinkPrices.put("1", 2.0);
        drinkPrices.put("2", 2.5);
        drinkPrices.put("3", 3.0);

        if (drinkPrices.containsKey(sizeChoice))
        {
            System.out.println(Colors.BRIGHT_GREEN + "What drink would you like?" + Colors.TEXT_RESET);
            System.out.println(Colors.BRIGHT_WHITE + "[1] Coca-Cola");
            System.out.println("[2] Sprite");
            System.out.println("[3] Barq's");
            System.out.println("[4] Calypso Lemonade");
            System.out.println("[5] Water");
            System.out.println("[6] Iced Tea" + Colors.TEXT_RESET);
            System.out.print("Please enter your selection here: ");
            int drinkChoice = keyboard.nextInt();
            List<String> drinks = Arrays.asList("Coca-Cola", "Sprite", "Barq's", "Calypso Lemonade", "Water", "Iced Tea");
            createOrder.drinks.add(drinks.get(drinkChoice - 1));

            double drinkPrice = drinkPrices.get(sizeChoice);
            createOrder.setDrinkChipTotal(drinkPrice);
        }
        else
        {
            System.out.println("Invalid entry. Please try again.");
        }
    }

    private void addChips()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(Colors.BRIGHT_BLUE + "What chips would you like?" + Colors.TEXT_RESET);
        System.out.println(Colors.BRIGHT_WHITE + "[1] Lay's Classic");
        System.out.println("[2] Lay's BBQ");
        System.out.println("[3] Lay's Salt & Vinegar");
        System.out.println("[4] Lay's Sour Cream & Onion");
        System.out.println("[5] Sun Chips: Garden Salsa");
        System.out.println("[6] Hot Cheetos" + Colors.TEXT_RESET);
        System.out.print("Please enter your selection here: ");
        int chipChoice = keyboard.nextInt();

        double chipPrice = 1.50;
        createOrder.setDrinkChipTotal(chipPrice);
        System.out.println(Colors.BRIGHT_CYAN + "Chips successfully added!" + Colors.TEXT_RESET);
        List<String> chip = Arrays.asList("Lay's Classic", "Lay's BBQ", "Lay's Salt & Vinegar", "Lay's Sour Cream & Onion", "Sun Chips' Garden Salsa", "Hot Cheetos");
        createOrder.chips.add(chip.get(chipChoice - 1));
    }

    private static void addDisplaySandwich(Sandwich sandwich)
    {
        createOrder.sandwiches.add(sandwich);
        for (Sandwich sandwiches : createOrder.sandwiches)
        {
            System.out.println(sandwiches.getBread() + " " + sandwiches.getSize() + sandwiches.meatToppings + sandwiches.cheeseToppings + sandwiches.sauceToppings + sandwiches.vegetableToppings + sandwiches.sideToppings);

            for (Sandwich sandwiches1 : createOrder.sandwiches)
            {
                sandwiches1.getTotalPrice();
            }
        }
        createOrder.setSandwichPrices();
    }

    private void checkout() throws IOException
    {
        System.out.println();
        System.out.println(Colors.BRIGHT_WHITE + "ORDER DETAILS: ");
        System.out.println("-----");
        System.out.println("DRINKS: ");

        for (String drinks : createOrder.drinks)
        {
            if (createOrder.drinks.isEmpty())
            {
                System.out.print("~ No Drink ~");
            }
            else
            {
                System.out.println(drinks);
            }
        }
        System.out.println("-----");
        System.out.println("CHIPS: ");
        for (String chips : createOrder.chips)
        {
            if (createOrder.chips.isEmpty())
            {
                System.out.print("~ No Chippies ~");
            } else {
                System.out.println(chips);
            }
        }
        System.out.println("-----");
        System.out.println("SANDWICH: ");
        for (Sandwich sandwiches : createOrder.sandwiches)
        {
            System.out.println("Bread: " + sandwiches.getBread());
            System.out.println("Size: " + sandwiches.getSize());

            if(!sandwiches.meatToppings.isEmpty())
            {
                System.out.print(sandwiches.meatToppings + " ");
            }
            if(!sandwiches.cheeseToppings.isEmpty())
            {
                System.out.print(sandwiches.cheeseToppings + " ");
            }
            if(!sandwiches.sauceToppings.isEmpty())
            {
                System.out.print(sandwiches.sauceToppings + " ");
            }
            if(!sandwiches.vegetableToppings.isEmpty())
            {
                System.out.print(sandwiches.vegetableToppings + " ");
            }
            if(!sandwiches.sideToppings.isEmpty())
            {
                System.out.print(sandwiches.sideToppings + " ");
            }

            for (Sandwich sandwiches1 : createOrder.sandwiches)
            {
                sandwiches1.getTotalPrice();
            }
        }
        System.out.println();
        System.out.printf("Total Price: $ %.2f", createOrder.getTotal());
        System.out.println();
        System.out.println("The order has been confirmed! We appreciate the support!" + Colors.TEXT_RESET);
        Receipts receipt = new Receipts();
        receipt.write(createOrder);
        System.exit(0);

    }
}

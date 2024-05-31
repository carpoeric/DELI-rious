package com.pluralsight;

import java.util.ArrayList;

public class SignatureSandwiches
{
    ArrayList<Sandwich> signatureSandwiches;



    public SignatureSandwiches()
    {
        this.signatureSandwiches = new ArrayList<Sandwich>();
        orderBLT();
        orderPhillyCheese();
        orderChefCurry();
        orderEuphoria();
        orderHappyTrip();

    }

    public void orderBLT()
    {
        Sandwich blt = new Sandwich(8,"White",true);
        blt.meatToppings.add("Bacon");
        blt.cheeseToppings.add("Cheddar");
        blt.vegetableToppings.add("Lettuce");
        blt.vegetableToppings.add("Tomato");
        blt.sauceToppings.add("Ranch");
        blt.setSandwichPrice(11);
        blt.setDescription(" The BLT ($11) - A cult classic. The BLT is comprised of bacon and cheddar on a bed of freshly cut lettuce and tomatoes. It is dressed nicely with ranch and tucked away in 8 inch toasted white bread slices.");
        signatureSandwiches.add(blt);

    }

    public void orderPhillyCheese()
    {
        Sandwich phillyChesse = new Sandwich(8,"White",true);
        phillyChesse.meatToppings.add("Steak");
        phillyChesse.cheeseToppings.add("American");
        phillyChesse.vegetableToppings.add("Peppers");
        phillyChesse.sauceToppings.add("Mayo");
        phillyChesse.setSandwichPrice(11);
        phillyChesse.setDescription(" The Philly ($11) - The closest feeling to a Super Bowl win for an Eagles fan. 8 inch classic toasted steak sandwich topped with american, peppers, and mayo.");
        signatureSandwiches.add(phillyChesse);
    }

    public void orderChefCurry()
    {
        Sandwich chefCurry = new Sandwich(12,"White", true);
        chefCurry.meatToppings.add("Chicken");
        chefCurry.cheeseToppings.add("American");
        chefCurry.vegetableToppings.add("Lettuce");
        chefCurry.vegetableToppings.add("Tomatoes");
        chefCurry.vegetableToppings.add("Peppers");
        chefCurry.sauceToppings.add("Halal Sauce");
        chefCurry.setSandwichPrice(12.5);
        chefCurry.setDescription(" Chef Curry ($12.50) - Named after the flame-throwing NBA legend himself, this foot-long boasts our in-house halal chicken on a bed of veggies and toasted to perfection.");
        signatureSandwiches.add(chefCurry);
    }

    public void orderEuphoria()
    {
        Sandwich euphoriaSandwich = new Sandwich(8, "Wrap", false);
        euphoriaSandwich.meatToppings.add("Steak");
        euphoriaSandwich.cheeseToppings.add("Swiss");
        euphoriaSandwich.vegetableToppings.add("Lettuce");
        euphoriaSandwich.vegetableToppings.add("Onions");
        euphoriaSandwich.vegetableToppings.add("mushrooms");
        euphoriaSandwich.vegetableToppings.add("Peppers");
        euphoriaSandwich.sauceToppings.add("Thousand Islands");
        euphoriaSandwich.setSandwichPrice(12);
        euphoriaSandwich.setDescription(" Euphoria ($12.00) - Paired well with our Au Jus dipping side... This steak, melted swiss, and veggie wrap  will be something you won't be able to put down.");
        signatureSandwiches.add(euphoriaSandwich);
    }

    public void orderHappyTrip()
    {
        Sandwich happyTrip = new Sandwich(8,"White", true);
        happyTrip.meatToppings.add("Mushroom");
        happyTrip.cheeseToppings.add("Provolone");
        happyTrip.vegetableToppings.add("Lettuce");
        happyTrip.vegetableToppings.add("Peppers");
        happyTrip.vegetableToppings.add("Tomatoes");
        happyTrip.vegetableToppings.add("Cucumbers");
        happyTrip.vegetableToppings.add("Mushrooms");
        happyTrip.vegetableToppings.add("Guacamole");
        happyTrip.sauceToppings.add("Thousand Islands ");
        happyTrip.setSandwichPrice(11.5);
        happyTrip.setDescription(" Happy Trip ($11.50) - For all the 'shroom fans. ;) Our signature sandwich for those that love veggies. Comes with a grilled mushroom, provolone, and an abundant amount of veggies on top of White bread and Thousand Island dressing.");
        signatureSandwiches.add(happyTrip);
    }
}
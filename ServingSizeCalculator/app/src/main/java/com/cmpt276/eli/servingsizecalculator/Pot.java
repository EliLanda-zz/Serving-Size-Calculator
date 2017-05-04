package com.cmpt276.eli.servingsizecalculator;

/**
 * pots have a name and a weight. this class also lets you get and set those fields.
 */

public class Pot {
    String name;
    int weightInG;
    // Set member data based on parameters.
    public Pot(String name, int weightInG) {
        this.name = name;
        this.weightInG = weightInG;
    }

    // Return the weight
    public int getWeightInG() {

        return this.weightInG;
    }

    // Set the weight. Throws IllegalArgumentException if weight is less than 0.
    public void setWeightInG(int weightInG) {

        this.weightInG = weightInG;
    }

    // Return the name.
    public String getName() {

        return this.name;
    }

    // Set the name. Throws IllegalArgumentException if name is an empty string (length 0),
    // or if name is a null-reference.
    public void setName(String name) {

        this.name = name;
    }
}
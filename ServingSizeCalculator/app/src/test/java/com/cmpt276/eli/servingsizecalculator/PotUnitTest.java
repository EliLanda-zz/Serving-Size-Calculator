package com.cmpt276.eli.servingsizecalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the Pot class
 */

public class PotUnitTest {
    @Test
    public void getWeightInG() throws Exception {
        Pot pot = new Pot("potNames", 500);
        assertEquals(500, pot.getWeightInG());
    }

    @Test
    public void setWeightInG() throws Exception {
        Pot pot = new Pot("potName", 500);
        pot.setWeightInG(200);
        assertEquals(200, pot.getWeightInG());
    }

    @Test
    public void getName() throws Exception {
        Pot pot = new Pot("potName", 500);
        assertEquals("potName", pot.getName());
    }

    @Test
    public void setName() throws Exception {
        Pot pot = new Pot("potName", 500);
        pot.setName("newPotName");
        assertEquals("newPotName", pot.getName());
    }
}

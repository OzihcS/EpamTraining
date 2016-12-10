package ua.nure.piontkovskyi.SummaryTask1.coffee;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeTest {


    @Test(expected = Exception.class)
    public void testConstructor() throws Exception {
        Coffee coffee = new Coffee(null, null);
    }

    @Test
    public void getGrade() throws Exception {
        Coffee coffee = new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN);
        assertTrue(CoffeeGrade.ARABICA.equals(coffee.getGrade()));
        assertFalse(CoffeeGrade.EKSCELSA.equals(coffee.getGrade()));
        assertFalse(CoffeeGrade.LIBERICA.equals(coffee.getGrade()));
        assertFalse(CoffeeGrade.ROBUSTA.equals(coffee.getGrade()));
    }

    @Test
    public void getState() throws Exception {
        Coffee coffee = new Coffee(CoffeeGrade.EKSCELSA, CoffeeState.INSTANT);
        assertTrue(CoffeeState.INSTANT.equals(coffee.getState()));
        assertFalse(CoffeeState.GRAIN.equals(coffee.getState()));
        assertFalse(CoffeeState.GROUND.equals(coffee.getState()));
    }

    @Test
    public void testToString() throws Exception {
        Coffee coffee = new Coffee(CoffeeGrade.ARABICA, CoffeeState.INSTANT);
        String expect = "Arabica(Instant)";
        assertTrue(coffee.toString().equals(expect));
        Coffee coffee1 = new Coffee(CoffeeGrade.ROBUSTA, CoffeeState.GRAIN);
        assertFalse(coffee1.toString().equals(expect));
    }

    @Test
    public void equals() throws Exception {
        Coffee c = new Coffee(CoffeeGrade.LIBERICA, CoffeeState.GROUND);
        assertTrue(new Coffee(CoffeeGrade.LIBERICA, CoffeeState.GROUND).equals(c));
        assertFalse(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GROUND).equals(c));
        assertTrue(c.equals(c));
        assertFalse(c.equals(null));
    }

    @Test
    public void testHashCode()throws Exception{
        Coffee c = new Coffee(CoffeeGrade.LIBERICA, CoffeeState.GROUND);
        int expected = c.hashCode();
        int hex = new Coffee(CoffeeGrade.LIBERICA, CoffeeState.GRAIN).hashCode();
        assertFalse(expected == hex);
        hex = c.hashCode();
        assertTrue(expected == hex);
    }

}
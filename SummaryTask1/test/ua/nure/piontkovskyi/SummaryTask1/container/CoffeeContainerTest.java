package ua.nure.piontkovskyi.SummaryTask1.container;

import org.junit.Test;
import ua.nure.piontkovskyi.SummaryTask1.coffee.Coffee;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeGrade;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeState;
import ua.nure.piontkovskyi.SummaryTask1.price.PriceList;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CoffeeContainerTest {

    private static final Double PRICE = 0.5;

    private static CoffeeContainer getCoffeeContainer(Coffee coffee, Double price,
                                                      ContainerVolume volume) throws Exception {
        PriceList priceList = new PriceList();
        Map<CoffeeState, Double> pricesForArabica = new HashMap<>();
        pricesForArabica.put(coffee.getState(), price);
        priceList.setPrice(coffee.getGrade(), pricesForArabica);
        CoffeeContainer grainArabicaSmallInPackage = new CoffeeContainer(coffee,
                volume, priceList, ContainerType.PACKAGE);
        return grainArabicaSmallInPackage;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithException() throws Exception {
        new CoffeeContainer(new Coffee(null, null), ContainerVolume.SMALL, null, ContainerType.PACKAGE);
    }

    @Test
    public void testConstructorWithoutException() throws Exception {
        CoffeeContainer container = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL);
        CoffeeContainer container1 = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL);
        assertTrue(container.equals(container1));
    }


    @Test
    public void getCoffee() throws Exception {
        Coffee coffee = new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN);
        Coffee expect = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL).getCoffee();
        assertTrue(expect.equals(coffee));
    }

    @Test
    public void getWeight() throws Exception {
        Integer coffeeWeight = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL).getVolume() * Coffee.COFFEE_DENSITY;
        Integer expect = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL).getWeight();
        assertTrue(expect.equals(coffeeWeight));
    }

    @Test
    public void getPrice() throws Exception {
        CoffeeContainer container = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL);
        Double coffeePrice = container.getPrice();
        Double expect = container.getWeight() * PRICE;
        assertTrue(expect.equals(coffeePrice));
    }

    @Test
    public void getVolume() throws Exception {
        CoffeeContainer coffeeContainer = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL);
        int coffeeVolume = coffeeContainer.getVolume();
        int expected = ContainerVolume.SMALL.getVolume();
        assertTrue(expected == coffeeVolume);
        expected = ContainerVolume.MEDIUM.getVolume();
        assertFalse(expected == coffeeVolume);
        expected = ContainerVolume.LARGE.getVolume();
        assertFalse(expected == coffeeVolume);
    }

    @Test
    public void testToString() throws Exception {
        String expect = "Arabica(Grain)Package: weight:2150 gr, price:1075.0$";
        assertTrue(expect.equals(getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL).toString()));
    }

    @Test
    public void testCompareTo() throws Exception {
        CoffeeContainer container = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL);
        int expect = (int) ((container.getPrice() / container.getWeight()) - ((container.getPrice() / container.getWeight())));
        int expect1 = container.compareTo(container);
        assertTrue(expect == expect1);
    }

    @Test
    public void testEquals() throws Exception {
        CoffeeContainer expected = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL);
        assertTrue(expected.equals(expected));
        assertFalse(expected.equals(null));
        CoffeeContainer container = getCoffeeContainer(new Coffee(CoffeeGrade.EKSCELSA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL);
        assertFalse(container.equals(expected));
        container = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GROUND),
                PRICE, ContainerVolume.SMALL);
        assertFalse(container.equals(expected));
        container = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GROUND),
                PRICE, ContainerVolume.MEDIUM);
        assertFalse(container.equals(expected));
        container = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GROUND),
                0.8, ContainerVolume.SMALL);
        assertFalse(container.equals(expected));
        container = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL);
        assertTrue(container.equals(expected));


    }

    @Test
    public void testHash() throws Exception {
        int expected = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL).hashCode();
        int container = getCoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                PRICE, ContainerVolume.SMALL).hashCode();
        assertTrue(expected == container);
    }
}
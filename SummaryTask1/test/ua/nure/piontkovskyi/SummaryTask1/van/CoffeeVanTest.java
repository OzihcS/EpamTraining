package ua.nure.piontkovskyi.SummaryTask1.van;

import org.junit.Test;
import ua.nure.piontkovskyi.SummaryTask1.coffee.Coffee;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeGrade;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeState;
import ua.nure.piontkovskyi.SummaryTask1.container.CoffeeContainer;
import ua.nure.piontkovskyi.SummaryTask1.container.ContainerType;
import ua.nure.piontkovskyi.SummaryTask1.container.ContainerVolume;
import ua.nure.piontkovskyi.SummaryTask1.price.PriceList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CoffeeVanTest {

    private static final Double PRICE = 0.5;

    private static CoffeeContainer getCoffeeContainer() throws Exception{
        PriceList priceList = new PriceList();
        Map<CoffeeState, Double> pricesForArabica = new HashMap<>();
        pricesForArabica.put(CoffeeState.GRAIN, PRICE);
        priceList.setPrice(CoffeeGrade.ARABICA, pricesForArabica);
        CoffeeContainer grainArabicaSmallInPackage = new CoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                ContainerVolume.SMALL, priceList, ContainerType.PACKAGE);
        return grainArabicaSmallInPackage;
    }

    @Test
    public void addCoffee() throws Exception {
        CoffeeVan van = new CoffeeVan(50);
        van.addCoffee(getCoffeeContainer());
        assertTrue(van.getContainers().size() != 0);
    }

    @Test(expected = Exception.class)
    public void addCoffeeWithException() throws Exception {
        CoffeeVan van = new CoffeeVan(1);
        van.addCoffee(getCoffeeContainer());
    }

    @Test
    public void sortByPriceToWeight() throws Exception {

        PriceList priceList = new PriceList();
        Map<CoffeeState, Double> pricesForArabica = new HashMap<>();
        pricesForArabica.put(CoffeeState.GRAIN, PRICE);
        priceList.setPrice(CoffeeGrade.ARABICA, pricesForArabica);
        CoffeeContainer grainArabicaLargeInPackage = new CoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GRAIN),
                ContainerVolume.LARGE, priceList, ContainerType.PACKAGE);

        CoffeeVan van = new CoffeeVan(60);
        van.addCoffee(getCoffeeContainer());
        van.addCoffee(grainArabicaLargeInPackage);
        CoffeeVan van1 = van;
        van.sortByPriceToWeight();
        assertFalse(van.getContainers().equals(van1));
    }

    @Test
    public void getFreeVolume() throws Exception {
        CoffeeVan van = new CoffeeVan(75);
        int expect = van.getFreeVolume();
        assertTrue(expect == 75);
    }

    @Test
    public void emptyVan() throws Exception {
        CoffeeVan van = new CoffeeVan(65);
        van.emptyVan();
        assertTrue(van.getContainers().size() == 0);
        assertTrue(van.getFreeVolume() == 65);
    }

    @Test
    public void getContainers() throws Exception {
        CoffeeVan van = new CoffeeVan(65);
        List<CoffeeContainer> containers = new ArrayList<>();
        assertTrue(containers.equals(van.getContainers()));
    }

    @Test
    public void findByCoffeeAndVolume() throws Exception {
        CoffeeVan van = new CoffeeVan(50);
        van.addCoffee(getCoffeeContainer());
        List<CoffeeContainer> list = van.findByCoffeeAndVolume(CoffeeGrade.ARABICA, CoffeeState.GRAIN, 0, 100);
        assertTrue(getCoffeeContainer().getCoffee().equals(list.get(0).getCoffee()));
    }
}
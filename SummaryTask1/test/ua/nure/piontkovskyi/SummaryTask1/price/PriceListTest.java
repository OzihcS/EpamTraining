package ua.nure.piontkovskyi.SummaryTask1.price;

import org.junit.Test;
import ua.nure.piontkovskyi.SummaryTask1.coffee.Coffee;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeGrade;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeState;
import ua.nure.piontkovskyi.SummaryTask1.container.CoffeeContainer;
import ua.nure.piontkovskyi.SummaryTask1.container.ContainerType;
import ua.nure.piontkovskyi.SummaryTask1.container.ContainerVolume;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PriceListTest {


    @Test
    public void setPrice() throws Exception {
        Map<CoffeeGrade, PriceCalculator> calculators = new HashMap<>();
        calculators.put(CoffeeGrade.ARABICA, new PriceCalculator(new HashMap<CoffeeState, Double>()));
        assertTrue(calculators.size() != 0);
    }

    @Test
    public void getPriceCalculator() throws Exception {
        PriceList list = new PriceList();
        Map<CoffeeState, Double> pricesForArabica = new HashMap<>();
        pricesForArabica.put(CoffeeState.GROUND, 0.3);
        list.setPrice(CoffeeGrade.ARABICA, pricesForArabica);
        PriceCalculator expected = list.getPriceCalculator(CoffeeGrade.ARABICA);
        assertTrue(expected.getClass().getSimpleName().equals("PriceCalculator"));
    }

    @Test
    public void getPrice() throws Exception {
        PriceList list = new PriceList();
        Map<CoffeeState, Double> pricesForArabica = new HashMap<>();
        pricesForArabica.put(CoffeeState.GROUND, 0.3);
        list.setPrice(CoffeeGrade.ARABICA, pricesForArabica);
        CoffeeContainer container = new CoffeeContainer(new Coffee(CoffeeGrade.ARABICA, CoffeeState.GROUND),
                ContainerVolume.SMALL, list, ContainerType.PACKAGE);
        Double expected = list.getPrice(CoffeeGrade.ARABICA, CoffeeState.GROUND) * container.getWeight();
        assertTrue(expected.equals(container.getPrice()));

        Double expected1 = list.getPrice(CoffeeGrade.ROBUSTA, CoffeeState.GROUND);
        assertTrue(expected1 == null);
    }
}
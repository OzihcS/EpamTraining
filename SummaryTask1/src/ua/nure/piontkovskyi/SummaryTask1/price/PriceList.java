package ua.nure.piontkovskyi.SummaryTask1.price;

import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeGrade;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeState;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class PriceList {

    private final Map<CoffeeGrade, PriceCalculator> calculators = new HashMap<>();

    /**
     *
     */
    public void setPrice(CoffeeGrade grade, Map<CoffeeState, Double> pricesForParticularType) {
        calculators.put(grade, new PriceCalculator(pricesForParticularType));
    }

    /**
     *
     */
    public PriceCalculator getPriceCalculator(CoffeeGrade grade) {
        return calculators.get(grade);
    }

    /**
     *
     */
    public Double getPrice(CoffeeGrade grade, CoffeeState state) {
        PriceCalculator calc = calculators.get(grade);
        if (calc != null) {
            return calc.getPrice(state);
        }
        return null;
    }
}

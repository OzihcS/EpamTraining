package ua.nure.piontkovskyi.SummaryTask1.price;


import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeState;

import java.util.Map;

/**
 *
 */
public class PriceCalculator implements Price {

    private final Map<CoffeeState, Double> prices;

    /**
     *
     */
    public PriceCalculator(Map<CoffeeState, Double> pricesForParticularGrade) {
        this.prices = pricesForParticularGrade;
    }

    /**
     *
     */
    @Override
    public Double getPrice(CoffeeState state) {
        return prices.get(state);
    }
}

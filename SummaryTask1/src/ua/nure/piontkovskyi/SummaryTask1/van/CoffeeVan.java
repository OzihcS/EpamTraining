package ua.nure.piontkovskyi.SummaryTask1.van;


import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeGrade;
import ua.nure.piontkovskyi.SummaryTask1.coffee.CoffeeState;
import ua.nure.piontkovskyi.SummaryTask1.container.CoffeeContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class CoffeeVan {

    private final List<CoffeeContainer> containers = new ArrayList<>();
    private final Integer fullVolume;
    private Integer currentVolume;

    /**
     *
     */
    public CoffeeVan(Integer fullVolume) {
        this.fullVolume = fullVolume;
        this.currentVolume = 0;
    }

    /**
     *
     */
    public void addCoffee(CoffeeContainer container) {
        if (getFreeVolume() >= container.getVolume()) {
            containers.add(container);
            currentVolume += container.getVolume();
        } else {
            throw new IllegalArgumentException("No space in van!");
        }
    }

    /**
     *
     */
    public void sortByPriceToWeight() {
        Collections.sort(containers);
    }

    /**
     *
     */
    public Integer getFreeVolume() {
        return fullVolume - currentVolume;
    }

    /**
     *
     */
    public void emptyVan() {
        containers.clear();
        currentVolume = 0;
    }

    /**
     *
     */
    public List<CoffeeContainer> getContainers() {
        return containers;
    }

    /**
     *
     */
    public List<CoffeeContainer> findByCoffeeAndVolume(CoffeeGrade grade, CoffeeState state, Integer
            startVolume, Integer endVolume) {
        List<CoffeeContainer> result = new ArrayList<>();
        for (CoffeeContainer p : containers) {
            if (p.getCoffee().getGrade() == grade &&
                    p.getCoffee().getState() == state &&
                    p.getVolume() >= startVolume &&
                    p.getVolume() <= endVolume) {
                result.add(p);
            }
        }
        return result;
    }
}

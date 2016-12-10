package ua.nure.piontkovskyi.SummaryTask1.container;

/**
 *
 */

import ua.nure.piontkovskyi.SummaryTask1.coffee.Coffee;
import ua.nure.piontkovskyi.SummaryTask1.price.PriceList;

public class CoffeeContainer implements Comparable<CoffeeContainer> {

    private final Coffee coffee;
    private final Integer weight;
    private final Double price;
    private final ContainerVolume volume;
    private final ContainerType containerType;

    /**
     *
     */
    public CoffeeContainer(Coffee coffee, ContainerVolume volume, PriceList price, ContainerType containerType) {
        this.coffee = coffee;
        this.volume = volume;
        this.weight = volume.getVolume() * Coffee.COFFEE_DENSITY;
        this.price = price.getPrice(coffee.getGrade(), coffee.getState()) * weight;
        this.containerType = containerType;
    }

    /**
     *
     */
    public Coffee getCoffee() {
        return coffee;
    }

    /**
     *
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     *
     */
    public Double getPrice() {
        return price;
    }

    /**
     *
     */
    public Integer getVolume() {
        return volume.getVolume();
    }

    /**
     *
     */
    @Override
    public int compareTo(CoffeeContainer o) {
        return (int) ((this.price / this.weight) - (o.price / o.weight));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CoffeeContainer that = (CoffeeContainer) o;

        if (volume != that.volume || !weight.equals(that.weight)) {
            return false;
        }
        if (!price.equals(that.price)) {
            return false;
        }
        if (!coffee.equals(that.coffee)) {
            return false;
        }
        return containerType == that.containerType;
    }

    @Override
    public int hashCode() {
        int result = coffee.hashCode();
        result = 31 * result + weight.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + volume.hashCode();
        result = 31 * result + containerType.hashCode();
        return result;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(coffee.toString()).
                append(containerType.toString()).
                append(": weight:").
                append(weight).
                append(" gr, price:").
                append(price).
                append("$");
        return stringBuilder.toString();
    }
}
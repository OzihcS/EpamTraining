package ua.nure.piontkovskyi.SummaryTask1.coffee;

/**
 *
 */
public enum CoffeeState {

    GRAIN, GROUND, INSTANT;

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.replace(1, stringBuilder.length(),
                stringBuilder.substring(1, stringBuilder.length()).toLowerCase());
        return stringBuilder.toString();
    }
}
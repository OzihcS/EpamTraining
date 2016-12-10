package ua.nure.piontkovskyi.SummaryTask1.coffee;

/**
 *
 */
public class Coffee {

    private final CoffeeGrade grade;
    private final CoffeeState state;
    public static final Integer COFFEE_DENSITY = 430;

    /**
     *
     */
    public Coffee(CoffeeGrade grade, CoffeeState state) {
        if (grade == null || state == null) {
            throw new IllegalArgumentException();
        } else {
            this.grade = grade;
            this.state = state;
        }
    }

    /**
     *
     */
    public CoffeeGrade getGrade() {
        return grade;
    }

    /**
     *
     */
    public CoffeeState getState() {
        return state;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(grade.toString()).
                append("(").
                append(state.toString()).
                append(")");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coffee coffee = (Coffee) o;
        if (grade != coffee.grade) {
            return false;
        }
        return state == coffee.state;

    }

    @Override
    public int hashCode() {
        int result = grade.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }
}

package ua.nure.piontkovskyi.SummaryTask1.container;

/**
 *
 */
public enum ContainerType {

    JAR, PACKAGE;
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

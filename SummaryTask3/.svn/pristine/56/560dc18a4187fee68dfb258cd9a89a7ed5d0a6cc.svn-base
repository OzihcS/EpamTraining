package ua.nure.piontkovskyi.SummaryTask3.entity;


/**
 * Enum of types for Bank
 */
public enum Type {
    POSTE_RESTANTE("posteRestante"), URGENT("urgent"), CALCULATED("calculated"),
    ROLLUP("rollup"), SAVINGS("savings"), METAL("metal");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Type getTypeByName(String name) {
        switch (name) {
            case "posteRestante": {
                return Type.POSTE_RESTANTE;
            }
            case "urgent": {
                return Type.URGENT;
            }
            case "calculated": {
                return Type.CALCULATED;
            }
            case "rollup": {
                return Type.ROLLUP;
            }
            case "savings": {
                return Type.SAVINGS;
            }
            case "metal": {
                return Type.METAL;
            }
        }
        return null;
    }
}

package ua.nure.piontkovskyi.SummaryTask3.entity;

/**
 * Elements in XML
 */
public class Bank {

    private String name;
    private String country;
    private Type type;
    private String depositorName;
    private Long accountId;
    private Double amountOnDeposit;
    private Double profitability;
    private Integer timeConstraint;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDepositorName() {
        return depositorName;
    }

    public void setDepositorName(String depositorName) {
        this.depositorName = depositorName;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getAmountOnDeposit() {
        return amountOnDeposit;
    }

    public void setAmountOnDeposit(Double amountOnDeposit) {
        this.amountOnDeposit = amountOnDeposit;
    }

    public Double getProfitability() {
        return profitability;
    }

    public void setProfitability(Double profitability) {
        this.profitability = profitability;
    }

    public Integer getTimeConstraint() {
        return timeConstraint;
    }

    public void setTimeConstraint(Integer timeConstraint) {
        this.timeConstraint = timeConstraint;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=============").append(System.lineSeparator());
        sb.append("Bank: ").append(name).append(" (").append(country).append(")").append(System.lineSeparator()).
                append("Type: ").append(type).append(System.lineSeparator()).
                append("Depositor: ").append(depositorName).append(" (").append(accountId).append(")").
                append(System.lineSeparator()).
                append("Amount: ").append(amountOnDeposit).append("$").append(System.lineSeparator()).
                append("Profitability: ").append(profitability).append("%").append(System.lineSeparator()).
                append("Time Constraint: ").append(timeConstraint).append(" year(s)").append(System.lineSeparator());
        sb.append("=============").append(System.lineSeparator());
        return sb.toString();
    }
}

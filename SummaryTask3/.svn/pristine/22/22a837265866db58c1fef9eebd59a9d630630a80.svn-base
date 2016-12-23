package ua.nure.piontkovskyi.SummaryTask3.util;

import ua.nure.piontkovskyi.SummaryTask3.entity.Bank;
import ua.nure.piontkovskyi.SummaryTask3.entity.Deposits;

import java.util.Collections;
import java.util.Comparator;

/**
 * Class that contains methods for sorting.
 */
public class Sorter {

    /**
     * Comparator which sort banks by profitability.
     */
    private static final Comparator<Bank> SORT_BY_PROFITABILITY = new Comparator<Bank>() {
        @Override
        public int compare(Bank o1, Bank o2) {
            return Double.compare(o1.getProfitability(), o2.getProfitability());
        }
    };

    /**
     * Comparator which sort banks by time constraints.
     */
    private static final Comparator<Bank> SORT_BY_TIME_CONSTRAINTS = new Comparator<Bank>() {
        @Override
        public int compare(Bank o1, Bank o2) {
            return Integer.compare(o1.getTimeConstraint(), o2.getTimeConstraint());
        }
    };

    /**
     * Comparator which sort banks by amount.
     */
    private static final Comparator<Bank> SORT_BY_AMOUNT = new Comparator<Bank>() {
        @Override
        public int compare(Bank o1, Bank o2) {
            return Double.compare(o1.getAmountOnDeposit(),o2.getAmountOnDeposit());
        }
    };


    /**
     * Method takes deposits for sorting and sort by time constraints.
     * @param deposits
     * @return Sorted deposits list.
     */
    public static Deposits sortByTimeConstraints(Deposits deposits) {
        Collections.sort(deposits.getList(), SORT_BY_TIME_CONSTRAINTS);
        return deposits;
    }

    /**
     * Method takes deposits for sorting and sort by amount.
     * @param deposits
     * @return Sorted deposits list.
     */
    public static Deposits sortByAmount(Deposits deposits){
        Collections.sort(deposits.getList(),SORT_BY_AMOUNT);
        return deposits;
    }

    /**
     * Method takes deposits for sorting and sort by profitability.
     * @param deposits
     * @return Sorted deposits list.
     */
    public static Deposits sortByProfitability(Deposits deposits) {
        Collections.sort(deposits.getList(), SORT_BY_PROFITABILITY);
        return deposits;
    }
}

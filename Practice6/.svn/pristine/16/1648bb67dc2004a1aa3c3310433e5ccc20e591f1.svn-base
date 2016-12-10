package ua.nure.piontkovskyi.Practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<Boolean> parking;

    public Parking(int n) {
        parking = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parking.add(false);
        }
    }

    public void arrive(int index) {
        for (int i = index; i < parking.size(); i++) {
            if (!parking.get(i)) {
                parking.set(i, true);
                return;
            }
        }
    }

    public void leave(int index) {
        parking.set(index, false);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Boolean b : parking) {
            if (b) {
                sb.append("[busy] ");
            } else {
                sb.append("[free] ");
            }
        }
        return sb.toString();
    }
}

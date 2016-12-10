package ua.nure.piontkovskyi.Practice6.part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    private List<Integer> peopleInArray;
    private List<Integer> peopleInLink;

    public Part2(int n) {
        peopleInArray = new ArrayList<>();
        peopleInLink = new LinkedList<>();
        for (int i = 0; i < n - 1; i++) {
            peopleInArray.add(i);
            peopleInLink.add(i);
        }
    }

    public long remove(List list) {
        long time = System.currentTimeMillis();
        int local = 0;
        while (list.size() != 1) {
            local += 2;
            while (local >= list.size()) {
                local = local - list.size();
            }
            list.remove(local);
        }
        return System.currentTimeMillis() - time;
    }

    public List<Integer> getPeopleInArray() {
        return peopleInArray;
    }

    public List<Integer> getPeopleInLink() {
        return peopleInLink;
    }

    public static void main(String[] args) {
        Part2 part2 = new Part2(5_000);
        System.out.println("ArrayList: " + part2.remove(part2.getPeopleInArray()) + " ms");
        System.out.println("LinkedList: " + part2.remove(part2.getPeopleInLink()) + " ms");
    }

}

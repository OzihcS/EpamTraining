package ua.nure.piontkovskyi.Practice4;

import ua.nure.piontkovskyi.Practice4.Part1.Part1;
import ua.nure.piontkovskyi.Practice4.Part2.Part2;
import ua.nure.piontkovskyi.Practice4.Part3.Part3;
import ua.nure.piontkovskyi.Practice4.Part4.Part4;
import ua.nure.piontkovskyi.Practice4.Part5.Part5;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    private static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "CP1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch (IOException ex) {
            System.out.println(fileName + "is not found or open");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("=========================== PART1");
        System.out.println(new Part1().doIt(getInput("part1.txt")));
        System.out.println("=========================== PART2");
        Part2.main(new String[]{});
        System.out.println("=========================== PART3");
        System.setIn(new ByteArrayInputStream(("char" + System.lineSeparator() + "String" +
                System.lineSeparator() + "int" + System.lineSeparator() + "double" + System.lineSeparator()
                + "stop").getBytes("CP1251")));
        new Part3().doIt(getInput("part3.txt"));
        System.setIn(System.in);
        System.out.println("=========================== PART4");
        new Part4().getFileContent();
        System.out.println("=========================== PART5");
        System.setIn(new ByteArrayInputStream(("table ru" + System.lineSeparator() + "language en" +
                System.lineSeparator() + "apple ru" + System.lineSeparator() + "stop").getBytes("CP1251")));
        new Part5().doIt();
        System.setIn(System.in);
    }
}

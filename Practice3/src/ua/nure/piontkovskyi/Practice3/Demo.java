package ua.nure.piontkovskyi.Practice3;

import ua.nure.piontkovskyi.Practice3.Part1.Part1;
import ua.nure.piontkovskyi.Practice3.Part2.Part2;
import ua.nure.piontkovskyi.Practice3.Part3.Part3;
import ua.nure.piontkovskyi.Practice3.Part4.Part4;
import ua.nure.piontkovskyi.Practice3.Part5.Part5;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Demo {

    private static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch (IOException ex) {
            System.err.println("Input exception!");
        }
        return sb.toString();
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = getInput("part1.txt");
        System.out.println(Part1.convert1(input));
        System.out.println(Part1.convert2(input));
        System.out.println(Part1.convert3(input));
        System.out.println(Part1.convert4(input));
        input = (getInput("part2.txt"));
        System.out.println(Part2.getMax(input));
        System.out.println(Part2.getMin(input));
        System.out.println(Part3.firstToUppercase("aaa Zasad яя ФЫв фыв ф фыапфч afasf 5 46 888"));
        System.out.println(Part4.hash("passwort", "SHA-256"));
        System.out.println(Part4.hash("password", "SHA-256"));
        System.out.println(Part5.decimal2Roman(75));
        System.out.println(Part5.roman2Decimal("LXXV"));
    }
}

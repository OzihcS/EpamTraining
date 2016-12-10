package ua.nure.piontkovskyi.Practice4.Part3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public void doIt(String s) {
        Pattern patternForChar = Pattern.compile("(?i)(^|(?<=\\s))[a-zа-я]($|(?=\\s))");
        Pattern patternForString = Pattern.compile("[\\w+]{2,}", Pattern.UNICODE_CHARACTER_CLASS);
        Pattern patternForInteger = Pattern.compile("(^|\\s)(\\d+)(\\s|$)");
        Pattern patternForDouble = Pattern.compile("(^|\\s)([\\d+]*\\.\\d+)(\\s|$)");
        Scanner in = new Scanner(System.in, "CP1251");
        String str;
        Matcher m;
        StringBuilder sb = new StringBuilder();
        while (!"stop".equalsIgnoreCase(str = in.nextLine())) {
            switch (str) {
                case "char":
                    m = patternForChar.matcher(s);
                    while (m.find()) {
                        sb.append(m.group()).append(" ");
                    }
                    System.out.println(sb.toString());
                    sb.delete(0, sb.length());
                    break;
                case "String":
                    m = patternForString.matcher(s);
                    while (m.find()) {
                        sb.append(m.group()).append(" ");
                    }
                    System.out.println(sb.toString());
                    sb.delete(0, sb.length());
                    break;
                case "int":
                    m = patternForInteger.matcher(s);
                    while (m.find()) {
                        sb.append(m.group()).append(" ");
                    }
                    System.out.println(sb.toString());
                    sb.delete(0, sb.length());
                    break;
                case "double":
                    m = patternForDouble.matcher(s);
                    while (m.find()) {
                        sb.append(m.group()).append(" ");
                    }
                    System.out.println(sb.toString());
                    sb.delete(0, sb.length());
                    break;
                default:
                    System.out.println("Command error!");
                    break;
            }
        }
        in.close();
    }
}

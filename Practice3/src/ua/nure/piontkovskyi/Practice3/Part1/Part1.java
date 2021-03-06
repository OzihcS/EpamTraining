package ua.nure.piontkovskyi.Practice3.Part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static String convert1(String input) {
        Pattern p = Pattern.compile("(.+);(.+.+.);((.+)@(.+.)(.+)(.+)*)");
        Matcher m = p.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            sb.append(m.group(1))
                    .append(" ==> ")
                    .append(m.group(3))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        Pattern p = Pattern.compile("(.+);(.+.+.);((.+)@(.+.)(.+)(.+)*)");
        Matcher m = p.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            sb.append(m.group(2))
                    .append(" (email: ")
                    .append(m.group(3))
                    .append(")")
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert3(String input) {
        Pattern p = Pattern.compile("^?(.+;)(.+;)(.+)(@.+)");
        Matcher m = p.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            Pattern p1 = Pattern.compile(m.group(4).substring(1));
            Matcher m1 = p1.matcher(sb);
            if (!m1.find()) {
                sb.append(System.lineSeparator()).
                        append(m.group(4).substring(1)).
                        append(" ==> ").
                        append(m.group(1).substring(0, m.group(1).length() - 1));
            } else {
                Pattern p3 = Pattern.compile(m.group(4).substring(1) + ".+");
                Matcher m3 = p3.matcher(sb);
                while (m3.find()) {
                    sb.insert(m3.end(),
                            ", " + m.group(1).substring(0, m.group(1).length() - 1));
                }
            }
        }
        return sb.toString().substring(2);
    }

    public static String convert4(String input) {
        String[] textInFile = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        sb.append(textInFile[0]).
                append(";Password").
                append(System.lineSeparator());
        for (int i = 1; i < textInFile.length; i++) {
            sb.append(textInFile[i]).
                    append(";").
                    append((int) (1000 + (Math.random() * ((10000 - 1000))))).
                    append(System.lineSeparator());
        }
        return sb.toString();
    }
}
package ua.nure.piontkovskyi.Practice3.Part3;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static String firstToUppercase(String s) {
        Pattern p = Pattern.compile("(.+)+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher(s);
        StringBuilder resultStr = new StringBuilder();
        while (m.find()) {
            Pattern p1 = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher m1 = p1.matcher(m.group());
            while (m1.find()) {
                StringBuilder tmpStr = new StringBuilder();
                tmpStr.append(m1.group());
                if (tmpStr.toString().equals(System.lineSeparator())) {
                    resultStr.append(System.lineSeparator());
                    continue;
                }
                tmpStr.setCharAt(0, Character.toUpperCase(tmpStr.charAt(0)));
                resultStr.append(tmpStr);
                resultStr.append(" ");
            }
            resultStr.append(System.lineSeparator());
        }
        return resultStr.toString();
    }
}

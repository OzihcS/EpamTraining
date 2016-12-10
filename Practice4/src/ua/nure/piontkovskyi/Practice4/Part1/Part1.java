package ua.nure.piontkovskyi.Practice4.Part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public String doIt(String s) {
        StringBuilder sb = new StringBuilder(s);
        Pattern p = Pattern.compile("(\\w+){3,}", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher(sb);
        while (m.find()) {
            sb.replace(m.start(), m.end(), m.group().toUpperCase());
        }
        return sb.toString();
    }
}

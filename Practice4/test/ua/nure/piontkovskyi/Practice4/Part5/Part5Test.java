package ua.nure.piontkovskyi.Practice4.Part5;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public class Part5Test {

    @Test
    public void test() {
        try {
            System.setIn(new ByteArrayInputStream("wrongInput".getBytes("CP1251")));
            new Part5().doIt();
            System.setIn(new ByteArrayInputStream(
                    ("incorrectKey ru").getBytes("CP1251")));
            new Part5().doIt();
            System.setIn(new ByteArrayInputStream(
                    ("table ru" + System.lineSeparator() + "language en" + System.lineSeparator()
                            + "apple ru" + System.lineSeparator() + "stop").getBytes("CP1251")));
            new Part5().doIt();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Wrong!");
        }
    }
}
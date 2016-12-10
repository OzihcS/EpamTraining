package ua.nure.piontkovskyi.Practice4.Part3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
public class Part3Test {
    @Test
    public void doIt() throws Exception {
        try {
            System.setIn(new ByteArrayInputStream((
                    "char" + System.lineSeparator() + "String" + System.lineSeparator() + "int"
                            + System.lineSeparator() + "double" + System.lineSeparator()
                            + "" + System.lineSeparator() + "stop" + System.lineSeparator()).getBytes("CP1251")));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Wrong!");
        }
        new Part3().doIt("5 test 2.8 Z");
        System.setIn(System.in);
    }

}
package ua.nure.piontkovskyi.Practice4.Part1;

import static org.junit.Assert.*;

public class Part1Test {
    @org.junit.Test
    public void doIt() throws Exception {
        String expected = "HELLO my WORLD";
        String str = new Part1().doIt("Hello my world");
        assertTrue(expected.equals(str));
    }

}
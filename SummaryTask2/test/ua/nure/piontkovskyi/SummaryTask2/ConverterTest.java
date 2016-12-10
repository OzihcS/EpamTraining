package ua.nure.piontkovskyi.SummaryTask2;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.Assert.*;

public class ConverterTest {


    @Test
    public void testConvert() throws IOException {
        Converter c = new Converter(3);
        c.getInput("testInput.txt");
        String expected = "фыва фывф уку";
        String s = c.convert();
        assertFalse(expected.equals(s));
    }

    @Test(expected = FileNotFoundException.class)
    public void testWithException() throws IOException {
        Converter c = new Converter(5);
        c.getInput("1.ccc");
    }

    @Test(expected = Exception.class)
    public void testMainWithException() throws Exception {
        Converter.main(new String[]{});
    }

    @Test
    public void testMain() throws Exception {
        Converter.main(new String[]{"input.txt"});
    }

    @Test
    public void testToString() throws IOException {
        Converter c = new Converter(3);
        c.getInput("testInput.txt");
        System.out.println(c.toString());
    }
}
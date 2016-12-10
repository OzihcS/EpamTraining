package ua.nure.piontkovskyi.Practice4.Part4;

import org.junit.Test;

import static org.junit.Assert.*;

public class Part4Test {
    @Test(expected = UnsupportedOperationException.class)
    public void getFileContent() throws Exception {
        Parser parser = new Parser("part4.txt");
        parser.iterator().remove();
    }

}
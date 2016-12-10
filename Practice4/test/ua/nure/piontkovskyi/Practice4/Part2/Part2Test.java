package ua.nure.piontkovskyi.Practice4.Part2;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.*;

public class Part2Test {
    @Test
    public void fillFIle() throws Exception {
        new Part2().fillFIle();
        File f = new File("inputPart2.txt");
        int[] arr = new Part2().read("inputPart2.txt");
        assertTrue(f.exists() && arr.length == 10);
    }

    @Test
    public void sortArray() throws Exception {
        int[] arr = {44, 4, 1, 20};
        int[] expected = {1, 4, 20, 44};
        arr = new Part2().sortArray(arr);
        assertTrue(Arrays.equals(arr, expected));
    }

    @Test
    public void show() throws Exception {
        Part2.main(new String[]{});
    }

}
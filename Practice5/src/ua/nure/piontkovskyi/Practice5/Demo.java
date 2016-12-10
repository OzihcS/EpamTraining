package ua.nure.piontkovskyi.Practice5;


import ua.nure.piontkovskyi.Practice5.Part1.Part1;
import ua.nure.piontkovskyi.Practice5.Part2.Part2;
import ua.nure.piontkovskyi.Practice5.Part3.Part3;
import ua.nure.piontkovskyi.Practice5.Part4.Part4;
import ua.nure.piontkovskyi.Practice5.Part5.Part5;
import ua.nure.piontkovskyi.Practice5.Part6.Part6;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Demo {

    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException, FileNotFoundException {
        System.out.println("===Part1====");
        Part1.main(new String[]{});
        System.out.println("===Part2====");
        Part2.main(new String[]{});
        System.out.println("===Part3====");
        Part3.main(new String[]{});
        System.out.println("===Part4====");
        Part4.main(new String[]{});
        System.out.println("===Part5====");
        Part5.main(new String[]{});
        System.out.println("===Part6====");
        Part6.main(new String[]{});
    }

}

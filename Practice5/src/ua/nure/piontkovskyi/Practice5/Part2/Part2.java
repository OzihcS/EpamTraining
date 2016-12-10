package ua.nure.piontkovskyi.Practice5.Part2;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Part2 {

    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        InputStream stdIn = System.in;
        ByteArrayInputStream bais = new ByteArrayInputStream(System.lineSeparator().getBytes("CP1251"));
        System.setIn(bais);
        Spam.main(args);
        Thread.sleep(1600);
        System.out.println("Try to send enter to standard input");
        System.setIn(stdIn);
    }
}

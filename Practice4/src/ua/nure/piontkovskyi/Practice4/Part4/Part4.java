package ua.nure.piontkovskyi.Practice4.Part4;


import java.io.FileNotFoundException;

public class Part4 {
    ;

    public void getFileContent() throws FileNotFoundException {
        Parser parser = new Parser("part4.txt");
        for (String s : parser) {
            System.out.println(s);
        }
    }
}
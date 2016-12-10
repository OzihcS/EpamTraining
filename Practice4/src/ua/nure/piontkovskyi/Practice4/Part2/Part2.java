package ua.nure.piontkovskyi.Practice4.Part2;


import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    private static final String INPUT_FILE = "inputPart2.txt";
    private static final String OUTPUT_FILE = "outputPart2.txt";

    void fillFIle() throws IOException {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(50);
        }
        write(arr, INPUT_FILE);
    }

    int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    private void write(int[] arr, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = Arrays.toString(arr).getBytes("CP1251");
        fos.write(buffer, 0, buffer.length);
        fos.close();
    }

    int[] read(String fileName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        int data = inputStream.read();
        StringBuilder sb = new StringBuilder();
        while (data != -1) {
            sb.append((char) data);
            data = inputStream.read();
        }
        inputStream.close();
        int[] arr = new int[10];
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(sb.toString());
        int i = 0;
        while (m.find()) {
            arr[i] = Integer.parseInt(m.group());
            i++;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        Part2 p = new Part2();
        p.fillFIle();
        p.read(INPUT_FILE);
        int[] arr = p.read(INPUT_FILE);

        System.out.print("input ==> ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        p.sortArray(arr);
        p.write(arr, OUTPUT_FILE);

        arr = p.read(OUTPUT_FILE);
        System.out.print("output ==> ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

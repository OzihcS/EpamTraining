package ua.nure.piontkovskyi.Practice5.Part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public final class Part6 extends Thread {

    private static String fileName = "part6.txt";
    private static final int NUMBER_OF_THREADS = 10;
    private static final int NUMBER_OF_CHARACTERS = 20;
    private RandomAccessFile out;

    private Part6() throws FileNotFoundException {
        out = new RandomAccessFile(fileName, "rw");
    }

    @Override
    public void run() {
        String numberOfCurrentThread = currentThread().getName()
                .substring(currentThread().getName().length() - 1);
        try {
            for (int i = 0; i < NUMBER_OF_CHARACTERS; i++) {
                out.write('0' + Integer.parseInt(numberOfCurrentThread));
            }
            out.write(System.lineSeparator().getBytes("CP1251"));
        } catch (IOException e1) {
            System.err.println(Thread.currentThread().getName() + " is interrupted");
        }
    }

    private static void writeToFile() throws FileNotFoundException {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            Part6 thread = new Part6();
            try {
                thread.out.seek(i * (NUMBER_OF_CHARACTERS + 2));
            } catch (IOException e) {
                System.err.println(Thread.currentThread().getName() + " is interrupted");
            }
            thread.start();
        }
    }

    private static String getContent() {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNext()) {
                sb.append(scanner.next());
                sb.append(System.lineSeparator());
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Input exception!");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        writeToFile();
        Thread.sleep(500);
        System.out.println(getContent());
    }
}
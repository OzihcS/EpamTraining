package ua.nure.piontkovskyi.Practice5.Part5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Note!!! Without synchronization this application not work properly!! Most
 * likely a runtime exception will be thrown..
 */
public class Part51 {

    private static final int ITERATION_NUMBER = 3;
    private static final int READERS_NUMBER = 3;

    // shared resource (not thread-safe!!!)
    private static final StringBuilder BUFFER = new StringBuilder();
    private static final int BUFFER_LENGTH = 5;
    // speed parameter
    private static final int PAUSE = 5;
    // stop signal
    private static boolean stop;

    //monitors
    private static Object monitor = new Object();
    private static Object monitor2 = new Object();
    private static final String EXCEPTION = Thread.currentThread().getName() + " is interrupted";

    // reader
    private static class Reader extends Thread {
        public void run() {
            while (!stop) {
                try {
                    synchronized (monitor) {
                        read(getName());
                    }
                    synchronized (monitor2) {
                        Thread.sleep(1000);
                        monitor2.notify();
                        monitor2.wait(300);
                    }
                } catch (InterruptedException e) {
                    System.out.println(EXCEPTION);
                }
            }
        }
    }

    // writer
    private static class Writer extends Thread {
        public void run() {
            int tact = 0;
            while (!stop) {
                try {
                    synchronized (monitor) {
                        write();
                    }
                    synchronized (monitor2) {
                        monitor2.notify();
                        monitor2.wait(1000);
                    }
                } catch (InterruptedException e) {
                    System.err.println(EXCEPTION);
                } finally {
                    if (++tact == ITERATION_NUMBER) {
                        stop = true;
                    }
                }
            }
        }
    }

    private static void read(String threadName) throws InterruptedException {
        System.out.printf("Reader %s:", threadName);
        for (int j = 0; j < BUFFER_LENGTH; j++) {
            Thread.sleep(PAUSE);
            System.out.print(BUFFER.charAt(j));
        }
        System.out.println();
        Thread.sleep(5);
    }

    private static void write() {
        // clear buffer
        BUFFER.setLength(0);

        // write to buffer
        System.err.print("Writer writes:");

        Random random = new Random();
        for (int j = 0; j < BUFFER_LENGTH; j++) {
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                System.err.println(EXCEPTION);
            }
            char ch = (char) ('A' + random.nextInt(26));
            System.err.print(ch);
            BUFFER.append(ch);
        }
        System.err.println();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            System.err.println(EXCEPTION);
        }
    }

    public static void main(String[] args) {
        // create writer
        Writer writer = new Writer();

        // create readers
        List<Thread> readers = new ArrayList<>();
        for (int j = 0; j < READERS_NUMBER; j++) {
            readers.add(new Reader());
        }

        // start writer
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.err.println(EXCEPTION);
        }
        writer.start();

        // start readers
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.err.println(EXCEPTION);
        }
        for (Thread reader : readers) {
            reader.start();
        }

        // main thread is waiting for the child threads
        try {
            writer.join();
        } catch (InterruptedException e) {
            System.err.println(EXCEPTION);
        }
        for (Thread reader : readers) {
            try {
                reader.join();
            } catch (InterruptedException e) {
                System.err.println(EXCEPTION);
            }
        }
    }

}
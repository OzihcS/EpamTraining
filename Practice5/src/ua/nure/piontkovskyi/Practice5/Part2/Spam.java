package ua.nure.piontkovskyi.Practice5.Part2;

import java.util.Scanner;

public final class Spam extends Thread {

    private int[] time = new int[]{1000, 500, 1000, 500, 2000};
    private String[] messages = new String[]{"message - 1", "message - 2", "message - 3",
            "message - 4", "message - 5"};

    @Override
    public void run() {
        for (int i = 0; i < time.length; i++) {
            System.out.println(messages[i]);
            try {
                Thread.sleep(time[i]);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "CP1251");
        Spam s = new Spam();
        s.start();
        in.nextLine();
        s.interrupt();
    }
}

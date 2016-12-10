package ua.nure.piontkovskyi.Practice5.Part1;


public class Part1 {

    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread() + " is interrupted");
        }

        Thread t2 = new Thread(new MyThread2());
        t2.start();
    }
}

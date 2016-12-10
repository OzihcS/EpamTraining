package ua.nure.piontkovskyi.Practice5.Part3;


public class Part3 {

    private int firstCounter;
    private int secondCounter;

    private void doIn() {
        firstCounter++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread() + "is interrupted");
        }
        secondCounter++;
        System.out.println("Not synchronized:" + (firstCounter - secondCounter));
    }

    private void doItSynchronized() {
        synchronized (this) {
            firstCounter++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

                System.out.println(Thread.currentThread() + "is interrupted");
            }
            secondCounter++;
            System.out.println("Synchronized:" + (firstCounter - secondCounter));
        }
    }

    public static void main(String[] args) {
        final Part3 part3 = new Part3();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    part3.doItSynchronized();
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread() + "is interrupted");
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    part3.doIn();
                }
            }).start();
        }
    }
}

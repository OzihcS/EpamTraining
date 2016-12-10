package ua.nure.piontkovskyi.Practice5.Part1;

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(currentThread().getName() + " is interrupted");
            }
        }
    }
}

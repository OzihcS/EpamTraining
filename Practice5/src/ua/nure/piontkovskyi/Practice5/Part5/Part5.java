package ua.nure.piontkovskyi.Practice5.Part5;

public class Part5 {

    private static final String EXCEPTION = Thread.currentThread().getName() + " is interrupted";

    public static void main(String[] args) {
        System.out.println("============Part51");
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            System.err.println(EXCEPTION);
        }
        Part51.main(args);
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            System.err.println(EXCEPTION);
        }

        System.out.println("============Part52");
        try {
            Thread.sleep(5);
        } catch (InterruptedException e1) {
            System.err.println(EXCEPTION);
        }
        Part52.main(args);
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            System.err.println(EXCEPTION);
        }
        System.out.println("============Part53");
        Part53.main(args);
    }
}

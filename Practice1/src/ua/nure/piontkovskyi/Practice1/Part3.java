package ua.nure.piontkovskyi.Practice1;


public class Part3 {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.print("GCD: " + a + " and " + b + " = ");
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        System.out.println(a);
    }
}

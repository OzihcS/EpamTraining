package ua.nure.piontkovskyi.Practice1;


public class Part4 {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int sum = 0;
        System.out.println("Number:" + a);
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        System.out.println(sum);
    }
}

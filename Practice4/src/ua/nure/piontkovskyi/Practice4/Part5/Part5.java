package ua.nure.piontkovskyi.Practice4.Part5;


import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public void doIt() {
        Scanner sc = new Scanner(System.in, "CP1251");
        while (sc.hasNext()) {
            try {
                String[] command = sc.nextLine().split(" ");
                if (command[0].equalsIgnoreCase("stop")) {
                    return;
                }
                if (command.length != 2) {
                    System.out.println("Wrong input: [key][value]");
                    continue;
                }
                Locale locale = new Locale(command[1]);
                ResourceBundle rb = ResourceBundle.getBundle("resources", locale);
                System.out.println(rb.getString(command[0]));
            } catch (MissingResourceException e) {
                System.out.println("Wrong key");
            }
        }
        sc.close();
    }
}
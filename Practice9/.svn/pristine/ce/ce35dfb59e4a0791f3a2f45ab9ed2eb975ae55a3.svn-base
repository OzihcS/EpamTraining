package ua.nure.piontkovskyi.Practice9.task2;


import java.util.HashMap;
import java.util.Map;

public class Vote {

    private static Map<String, String> map;
    private static boolean flag = false;
    private static int footballCounter;
    private static int biathlonCounter;
    private static int basketballCounter;

    public static void vote(String userName, String select) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (!map.containsKey(userName)) {
            map.put(userName, select);
            flag = false;
        } else {
            flag = true;
        }
        if (!flag) {
            switch (select) {
                case "Football": {
                    footballCounter++;
                    break;
                }
                case "Biathlon": {
                    biathlonCounter++;
                    break;
                }
                case "Basketball": {
                    basketballCounter++;
                    break;
                }
            }
        }
    }

    public static boolean alreadyVoted(String name) {
        if (map == null || !map.containsKey(name)) {
            return false;
        }
        return true;
    }

    public static int getFootballCounter() {
        return footballCounter;
    }

    public static void setFootballCounter(int footballCounter) {
        Vote.footballCounter = footballCounter;
    }

    public static int getBiathlonCounter() {
        return biathlonCounter;
    }

    public static void setBiathlonCounter(int biathlonCounter) {
        Vote.biathlonCounter = biathlonCounter;
    }

    public static int getBasketballCounter() {
        return basketballCounter;
    }

    public static void setBasketballCounter(int basketballCounter) {
        Vote.basketballCounter = basketballCounter;
    }

    public static Map<String, String> getMap() {
        return map;
    }
}

package ua.nure.piontkovskyi.Practice3.Part5;


public class Part5 {

    private static final String[] ROMAN_NUMBERS = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    private static final int[] ARAB_NUMBERS = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100};

    public static String decimal2Roman(int x) {
        if (x > 100) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        int x2 = x;
        for (int i = ARAB_NUMBERS.length - 1; i >= 0; i--) {
            while (x2 >= ARAB_NUMBERS[i]) {
                sb.append(ROMAN_NUMBERS[i]);
                x2 -= ARAB_NUMBERS[i];
            }
        }
        return sb.toString();
    }

    public static int roman2Decimal(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (result > 100) {
                throw new IllegalArgumentException();
            }
            char ch = s.charAt(i);
            switch (ch) {
                case 'I':
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        result -= 1;
                        break;
                    }
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'L':
                    if (i > 0 && s.charAt(i - 1) == 'X') {
                        result += 30;
                        break;
                    }
                    result += 50;
                    break;
                default:
                    if (i > 0 && s.charAt(i - 1) == 'X') {
                        result += 80;
                        break;
                    }
                    result += 100;
            }
        }
        return result;
    }
}
package ua.nure.piontkovskyi.Practice3.Part4;


import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes(Charset.forName("UTF-8")));
        byte[] hash = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            if (b < 0) {
                String hex = Integer.toHexString(b);
                sb.append(hex.substring(hex.length() - 2, hex.length())).append(" ");
            } else {
                sb.append(Integer.toHexString(b)).append(" ");
            }
        }
        return sb.toString().toUpperCase();
    }
}

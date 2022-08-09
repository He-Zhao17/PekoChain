/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-08-09 17:57
 */


//use SHA256 to encrypt
import java.security.MessageDigest;

public class StringUtility {
    public static String applySHA256 (String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append(hex);
                }

            }
            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "nishuone";
        StringUtility su = new StringUtility();
        su.applySHA256(input);
    }


}

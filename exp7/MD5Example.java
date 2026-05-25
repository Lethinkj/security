import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {

    public static void main(String[] args) {

        try {

            // Input message
            String message = "Hello World";

            // Create MD5 object
            MessageDigest md =
                    MessageDigest.getInstance("MD5");

            // Generate message digest
            byte[] messageDigest =
                    md.digest(message.getBytes());

            // Convert byte array into hexadecimal
            StringBuilder sb = new StringBuilder();

            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }

            // Display result
            System.out.println("Original Message: " + message);
            System.out.println("MD5 Hash: " + sb.toString());

        }

        catch (NoSuchAlgorithmException e) {

            System.out.println("Exception: " + e);
        }
    }
}
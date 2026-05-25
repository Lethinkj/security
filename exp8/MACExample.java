import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MACExample {

    public static void main(String[] args) {

        try {

            // Step 1: Generate Secret Key
            KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA512");
            SecretKey secretKey = keygen.generateKey();

            // Step 2: Message
            String message = "Hello, world!";

            // Step 3: Create MAC object
            Mac mac = Mac.getInstance("HmacSHA512");

            // Step 4: Initialize MAC with secret key
            mac.init(secretKey);

            // Step 5: Generate MAC
            byte[] macBytes = mac.doFinal(message.getBytes());

            // Output
            System.out.println("Message: " + message);
            System.out.println("MAC: " + bytesToHex(macBytes));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    // Convert bytes to Hexadecimal
    private static String bytesToHex(byte[] bytes) {

        StringBuilder result = new StringBuilder();

        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }

        return result.toString();
    }
}
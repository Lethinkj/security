import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws Exception {

        // Generate key
        SecretKey secretKey =
                KeyGenerator.getInstance("AES").generateKey();

        // Original message
        String originalMessage = "Hello, world!";

        // Create Cipher instance
        Cipher cipher = Cipher.getInstance("AES");

        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedMessage =
                cipher.doFinal(originalMessage.getBytes(StandardCharsets.UTF_8));

        // Convert encrypted bytes to Base64
        String encodedMessage =
                Base64.getEncoder().encodeToString(encryptedMessage);

        System.out.println("Original Message: " + originalMessage);
        System.out.println("Encrypted Message: " + encodedMessage);

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedMessage =
                cipher.doFinal(Base64.getDecoder().decode(encodedMessage));

        System.out.println("Decrypted Message: " +
                new String(decryptedMessage, StandardCharsets.UTF_8));
    }
}
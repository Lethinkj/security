import java.util.Scanner;

public class DictionaryAttackDemo {

    public static void main(String[] args) {

        // Common passwords dictionary
        String[] dictionary = {
            "password",
            "123456",
            "qwerty",
            "admin",
            "letmein"
        };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String userPassword = scanner.nextLine();

        boolean isPasswordInDictionary = false;

        // Check password
        for (String commonPassword : dictionary) {

            if (userPassword.equals(commonPassword)) {
                isPasswordInDictionary = true;
                break;
            }
        }

        // Result
        if (isPasswordInDictionary) {
            System.out.println("Password is weak! Please choose a stronger one.");
        } else {
            System.out.println("Password is secure. Good job!");
        }

        scanner.close();
    }
}
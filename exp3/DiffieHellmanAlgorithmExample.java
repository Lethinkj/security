import java.util.*;

class DiffieHellmanAlgorithmExample {

    public static void main(String[] args) {

        long P, G, x, a, y, b, ka, kb;

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Both users should agree upon public keys G and P");

        // Input public keys
        System.out.println("Enter value for public key G:");
        G = sc.nextLong();

        System.out.println("Enter value for public key P:");
        P = sc.nextLong();

        // Input private keys
        System.out.println(
                "Enter value for private key a selected by user1:");
        a = sc.nextLong();

        System.out.println(
                "Enter value for private key b selected by user2:");
        b = sc.nextLong();

        // Generate public keys
        x = calculatePower(G, a, P);
        y = calculatePower(G, b, P);

        // Generate secret keys
        ka = calculatePower(y, a, P);
        kb = calculatePower(x, b, P);

        // Display secret keys
        System.out.println("Secret key for User1 is: " + ka);
        System.out.println("Secret key for User2 is: " + kb);
    }

    // Function to calculate x^y mod P
    private static long calculatePower(long x, long y, long P) {

        long result;

        if (y == 1) {
            return x;
        }

        else {
            result = ((long)Math.pow(x, y)) % P;
            return result;
        }
    }
}
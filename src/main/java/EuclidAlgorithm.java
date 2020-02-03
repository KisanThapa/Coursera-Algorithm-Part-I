import java.util.Scanner;

/**
 * Euclid’s algorithm for finding the greatest common divisor of two numbers
 * <p>
 * Solution:
 * Compute the greatest common divisor of two non-negative integers p and q as follows:
 * If q is 0, the answer is p. If not, divide p by q and take the remainder r.
 * The answer is the greatest common divisor of q and r.
 */

public class EuclidAlgorithm {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter two integers to find the Greatest Common Divisor: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();

        int ans = divisor(n1, n2);
        System.out.println("Greatest common divisor of " + n1 + " and " + n2 + " is: " + ans);
    }

    private static int divisor(int p, int q) {

        if (q == 0)
            return p;
        int r = p % q;
        return divisor(q, r);

    }

}

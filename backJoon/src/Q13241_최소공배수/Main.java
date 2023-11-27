package Q13241_최소공배수;

import java.util.Scanner;

public class Main {
    private static long GCD(long A, long B) {
        if (B == 0) return A;
        return GCD(B, A % B);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        System.out.println(A *  B / GCD(B, A));
    }
}

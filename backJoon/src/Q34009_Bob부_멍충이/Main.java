package Q34009_Bob부_멍충이;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Long[] A = new Long[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        Arrays.sort(A, Collections.reverseOrder());

        long aliceScore = 0;
        long bobScore = 0;

        for (int i = 0; i < N; i++) {
            if ((N - i) % 2 == 0) {
                aliceScore += A[i];
            } else {
                bobScore += A[i];
            }

            if (aliceScore <= bobScore) {
                System.out.println("Bob");
                sc.close();
                return;
            }
        }
        System.out.println("Alice");
    }
}

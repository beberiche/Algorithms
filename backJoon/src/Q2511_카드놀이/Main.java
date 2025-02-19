package Q2511_카드놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk1 = new StringTokenizer(br.readLine());
        StringTokenizer stk2 = new StringTokenizer(br.readLine());
        int A = 0;
        int B = 0;

        String winner = "D";

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(stk1.nextToken());
            int M = Integer.parseInt(stk2.nextToken());

            if (N > M) {
                winner = "A";
                A += 3;
            } else if (N < M) {
                winner = "B";
                B += 3;
            } else {
                A += 1;
                B += 1;
            }
        }

        if (A > B) {
            System.out.println(A + " " + B);
            System.out.println("A");
        } else if (A < B) {
            System.out.println(A + " " + B);
            System.out.println("B");
        } else {
            System.out.println(A + " " + B);
            System.out.println(winner);
        }
    }
}

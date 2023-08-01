package Q16953_A_B;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static long A, B, ans;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();
    }

    private static void solve() {
        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{A, 1});
        while (!q.isEmpty()) {
            long[] curr = q.poll();
            if (curr[0] == B) {
                ans = curr[1];
                break;
            }

            if (curr[0] * 2 <= B) q.add(new long[]{curr[0] * 2, curr[1] + 1});
            if (curr[0] * 10 + 1 <= B) q.add(new long[]{curr[0] * 10 + 1, curr[1] + 1});
        }
    }

    private static void output() {
        System.out.print(ans == 0 ? -1 : ans);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}

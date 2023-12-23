package Q12852_1로_만들기_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    int N, dp[][], arr[];

    public static void main(String[] args) {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
        System.out.println();
    }

    private void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(arr.length - 1);
        System.out.print(sb.toString());
    }

    private void solve() {
        Queue<int[]> q = new LinkedList<>();
        // [0] = 현재 수
        // [1] = 이전 수
        // [2] = 카운트
        q.add(new int[]{N, -1, 0});
        dp[N][0] = N;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (dp[curr[0]][2] <= curr[2]) {
                continue;
            }

            dp[curr[0]][1] = curr[1];
            dp[curr[0]][2] = curr[2];

            if (curr[0] == 1) {
                break;
            }

            if (dp[curr[0]][0] % 3 == 0) {
                q.add(new int[]{curr[0] / 3, curr[0], curr[2] + 1});
            }

            if (dp[curr[0]][0] % 2 == 0) {
                q.add(new int[]{curr[0] / 2, curr[0], curr[2] + 1});
            }

            q.add(new int[]{curr[0] - 1, curr[0], curr[2] + 1});
        }

        arr = new int[dp[1][2] + 1];
        int idx = 0;
        int num = 1;
        while (num != N) {
            arr[idx++] = dp[num][0];
            num = dp[num][1];
        }
        arr[idx] = N;
    }

    private void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = i;
            dp[i][1] = i;
            dp[i][2] = Integer.MAX_VALUE;
        }
    }
}

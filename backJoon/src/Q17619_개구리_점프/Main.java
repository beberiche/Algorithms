package Q17619_개구리_점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int N, Q, pos[][], p[];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stk;
    StringBuilder sb = new StringBuilder();

    private void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());

        p = new int[N + 1];
        pos = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            p[i] = i;
            pos[i] = new int[]{i, n1, n2};
        }

        Arrays.sort(pos, (a1, a2) -> {
            if (a1[1] == a2[1]) return a1[2] - a2[2];
            return a1[1] - a2[1];
        });
    }

    private int find(int num) {
        if (p[num] == num) return num;
        return p[num] = find(p[num]);
    }


    private void solve() throws Exception {
        int[] prev = pos[1];

        for (int i = 2; i <= N; i++) {
            int[] curr = pos[i];

            if (curr[1] <= prev[2]) {
                int x = find(prev[0]);
                int y = find(curr[0]);

                p[x < y ? y : x] = x < y ? x : y;
                prev[2] = Math.max(prev[2], curr[2]);
            } else {
                prev[0] = curr[0];
                prev[1] = curr[1];
                prev[2] = curr[2];
            }
        }

        for (int i = 0; i < Q; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            int x = find(n1);
            int y = find(n2);

            sb.append((x == y ? 1 : 0)).append("\n");
        }
    }

    private void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }
}

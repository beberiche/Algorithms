package Q21773_가희와_프로세스_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static PriorityQueue<int[]> pq;
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        T = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        pq = new PriorityQueue<>((n1, n2) -> {
            if (n1[2] == n2[2]) return n1[0] - n2[0];
            return n2[2] - n1[2];
        });

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            int C = Integer.parseInt(stk.nextToken());
            pq.add(new int[]{A, B, C});
        }
    }

    private static void solve() throws Exception {
        int[] curr;
        while (--T >= 0) {
            curr = pq.poll();
            sb.append(curr[0] + "\n");
            curr[1]--;
            curr[2]--;
            if (curr[1] > 0) pq.add(curr);
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

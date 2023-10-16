package Q14867_물통;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Fill(A), Fill(B)
// Empty(A), Empty(B)
// Move(A,B), Move(B,A) 구현하기
public class Main {
    static int A, B, C, D, ans = -1;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());
    }

    private static void solve() {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 0});
        HashSet<String> s = new HashSet<>();
        StringBuilder sb;
        String str;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            sb = new StringBuilder();
            sb.append(curr[0]).append("/").append(curr[1]);
            str = sb.toString();
            if (s.contains(str)) continue;

            s.add(str);

            if (curr[0] == C && curr[1] == D) {
                ans = curr[2];
                break;
            }

            // Fill
            if (curr[0] != A) q.add(new int[]{A, curr[1], curr[2] + 1});
            if (curr[1] != B) q.add(new int[]{curr[0], B, curr[2] + 1});

            // Empty
            if (curr[0] != 0) q.add(new int[]{0, curr[1], curr[2] + 1});
            if (curr[1] != 0) q.add(new int[]{curr[0], 0, curr[2] + 1});

            // Move A->B
            if (curr[0] + curr[1] > B) q.add(new int[]{curr[0] - (B - curr[1]), B, curr[2] + 1});
            else q.add(new int[]{0, curr[0] + curr[1], curr[2] + 1});

            // Move B->A
            if (curr[0] + curr[1] > A) q.add(new int[]{A, curr[1] - (A - curr[0]), curr[2] + 1});
            else q.add(new int[]{curr[0] + curr[1], 0, curr[2] + 1});

        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

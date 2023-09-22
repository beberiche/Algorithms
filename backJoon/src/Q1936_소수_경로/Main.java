package Q1936_소수_경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean prime[];
    static int A, B;
    static StringTokenizer stk;
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());
    }

    private static void getPrime() {
        prime = new boolean[10000];
        prime[1] = true;
        for (int i = 2; i <= 9999; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j <= 9999; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    private static void solve() {
        boolean[] visited = new boolean[10000];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{A, 0});
        visited[A] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int num = curr[0];
            if (num == B) {
                sb.append(curr[1]).append("\n");
                return;
            }
            String str = curr[0] + "";
            for (int i = 0; i < 4; i++) {
                int st = 0;
                if (i == 0) st = 1;
                int div = (int) Math.pow(10, (4 - i - 1));
                int n = (str.charAt(i) - '0') * div;
                num -= n;
                for (int j = st; j <= 9; j++) {
                    num += j * div;
                    if (!visited[num] && !prime[num]) {
                        visited[num] = true;
                        q.add(new int[]{num, curr[1] + 1});
                    }
                    num -= j * div;
                }
                num += n;
            }
        }

        sb.append("Impossible").append("\n");
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        getPrime();
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
        }
        output();
    }
}

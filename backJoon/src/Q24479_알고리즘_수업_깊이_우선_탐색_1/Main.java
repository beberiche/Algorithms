package Q24479_알고리즘_수업_깊이_우선_탐색_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N, M, R, cnt[], idx = 1;
    static TreeSet<Integer> s[];
    static boolean visited[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        cnt = new int[N + 1];
        s = new TreeSet[N + 1];

        for (int i = 1; i <= N; i++) {
            s[i] = new TreeSet<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            s[n1].add(n2);
            s[n2].add(n1);
        }

        visited = new boolean[N + 1];

    }

    private static void dfs(int num) {
        visited[num] = true;
        cnt[num] = idx++;
        for (int n : s[num]) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(cnt[i]).append("\n");
        }
        System.out.print(sb.toString());

    }

    public static void main(String[] args) throws Exception {
        input();
        dfs(R);
        output();
    }
}

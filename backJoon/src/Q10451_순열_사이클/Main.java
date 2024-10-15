package Q10451_순열_사이클;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] a;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                a[i] = Integer.parseInt(stk.nextToken());
            }

            visited = new boolean[N + 1];
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    go(i);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void go(int idx) {
        if (visited[idx]) return;

        visited[idx] = true;

        go(a[idx]);
    }
}

package Q28251_나도리합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] p;
    private static long[] sum, res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());

        p = new int[N + 1];
        sum = new long[N + 1];
        res = new long[N + 1];

        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(stk.nextToken());
            p[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Q; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            int x = find(n1);
            int y = find(n2);

            if (x == y) {
                sb.append(res[x]).append("\n");
                continue;
            }


            // union 필요
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            res[x] += res[y] + sum[x] * sum[y];
            sb.append(res[x]).append("\n");
            sum[x] += sum[y];
            p[y] = x;
        }

        System.out.print(sb.toString());
    }

    private static int find(int node) {
        if (p[node] == node) return node;
        return p[node] = find(p[node]);
    }
}

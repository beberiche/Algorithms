package Q25587_배수로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int cnt;
    private static int[] p, a, b, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        p = new int[N + 1];
        a = new int[N + 1];
        c = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            p[i] = i;
            a[i] = Integer.parseInt(stk.nextToken());
            c[i] = 1;
        }

        b = new int[N + 1];
        cnt = 0;
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            b[i] = Integer.parseInt(stk.nextToken());
            if (a[i] < b[i]) cnt++;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            stk = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(stk.nextToken());

            if (cmd == 1) {
                int x = find(Integer.parseInt(stk.nextToken()));
                int y = find(Integer.parseInt(stk.nextToken()));

                if (x == y) continue;

                union(x, y);

            } else {
                sb.append(cnt).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    private static int find(int node) {
        if (p[node] == node) return node;
        return p[node] = find(p[node]);
    }

    private static void union(int node1, int node2) {
        if (node1 > node2) {
            int tmp = node1;
            node1 = node2;
            node2 = tmp;
        }

        if (a[node1] < b[node1]) {
            cnt -= c[node1];
        }

        if (a[node2] < b[node2]) {
            cnt -= c[node2];
        }

        p[node2] = node1;
        a[node1] += a[node2];
        b[node1] += b[node2];
        c[node1] += c[node2];


        if (a[node1] < b[node1]) {
            cnt += c[node1];
        }
    }
}

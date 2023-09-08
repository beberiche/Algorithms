package Q2250_트리의_높이와_너비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, p[], arr[][], idx = 1, MIN[], MAX[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        p = new int[N + 1];
        // 0 = left, 1 = right
        arr = new int[N + 1][2];
        MIN = new int[N + 1];
        MAX = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int n3 = Integer.parseInt(stk.nextToken());

            p[n1]++;
            if (n2 != -1) p[n2]++;
            if (n3 != -1) p[n3]++;

            MIN[i] = Integer.MAX_VALUE;
            MAX[i] = Integer.MIN_VALUE;

            arr[n1] = new int[]{n2, n3};
        }
    }

    private static int findRoot() {
        for (int i = 1; i <= N; i++) {
            if (p[i] == 1) return i;
        }
        // unreachable
        return -1;
    }

    private static void inOrder(int node, int d) {

        if (arr[node][0] != -1) inOrder(arr[node][0], d + 1);

        MIN[d] = Math.min(MIN[d], idx);
        MAX[d] = Math.max(MAX[d], idx++);

        if (arr[node][1] != -1) inOrder(arr[node][1], d + 1);
    }

    private static void solve() {
        int root = findRoot();
        inOrder(root, 1);
    }

    private static void output() {
        int ans = 0;
        int d = 1;
        for (int i = 1; i <= N; i++) {
            int dist = MAX[i] - MIN[i] + 1;
            if (ans < dist) {
                d = i;
                ans = dist;
            }
        }
        System.out.println(d + " " + ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

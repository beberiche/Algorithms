package Q20010_악덕_영주_혜유;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] p;
    private static int maxNode;
    private static long maxDist;
    private static List<int[]> list[];
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        p = new int[N];
        list = new ArrayList[N];
        int[][] a = new int[K][];
        list[0] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            p[i] = i;
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());
            a[i] = new int[]{n1, n2, dist};
        }
        Arrays.sort(a, (a1, a2) -> a1[2] - a2[2]);

        long sum = 0;
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            int x = find(a[i][0]);
            int y = find(a[i][1]);

            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            if (x != y) {
                cnt++;
                list[a[i][0]].add(new int[]{a[i][1], a[i][2]});
                list[a[i][1]].add(new int[]{a[i][0], a[i][2]});
                p[y] = x;
                sum += a[i][2];
            }

            if (cnt >= N - 1) break;
        }

        visited = new boolean[N];
        dfs(0, 0);
        Arrays.fill(visited, false);
        dfs(maxNode, 0);
        System.out.printf("%d\n%d", sum, maxDist);
    }

    private static void dfs(int node, long dist) {
        visited[node] = true;
        if (maxDist < dist) {
            maxNode = node;
            maxDist = dist;
        }
        for (int[] next : list[node]) {
            if (visited[next[0]]) continue;

            visited[next[0]] = true;
            dfs(next[0], dist + next[1]);
        }
    }

    private static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }
}

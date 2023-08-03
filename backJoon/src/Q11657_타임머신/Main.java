package Q11657_타임머신;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int from;
        int to;
        int dist;

        Node(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    static int N, M;
    static long cost[], INF = Long.MAX_VALUE, flag;
    static List<Node> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());
            list.add(new Node(from, to, dist));
        }
    }

    private static void solve() {
        cost = new long[N + 1];
        Arrays.fill(cost, INF);
        cost[1] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < list.size(); j++) {
                int from = list.get(j).from;
                int to = list.get(j).to;
                int dist = list.get(j).dist;

                if (cost[from] != INF && cost[to] > cost[from] + dist) {
                    cost[to] = cost[from] + dist;
                    if (i == N) {
                        flag = 9999;
                        return;
                    }
                }
            }
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        if (flag > 0) {
            System.out.print(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                cost[i] = cost[i] == INF ? -1 : cost[i];
                sb.append(cost[i]).append("\n");
            }
            System.out.print(sb.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

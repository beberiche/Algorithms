package Q1865_웜홀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int next;
        int dist;

        Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, W, INF = 987654321;
    static List<Node> g[];
    static boolean check;

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        W = Integer.parseInt(stk.nextToken());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        int n1, n2, dist;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());
            dist = Integer.parseInt(stk.nextToken());
            g[n1].add(new Node(n2, dist));
            g[n2].add(new Node(n1, dist));
        }

        for (int i = 0; i < W; i++) {
            stk = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());
            dist = Integer.parseInt(stk.nextToken());
            Node n = new Node(n2, dist * -1);
            g[n1].add(n);
        }
    }

    private static void solve() {
        int[] dist = new int[N + 1];
        check = false;
        for (int i = 1; i <= N; i++) {
            check = false;
            for (int j = 1; j <= N; j++) {
                for (Node n : g[j]) {
                    if (dist[n.next] > dist[j] + n.dist) {
                        dist[n.next] = dist[j] + n.dist;
                        check = true;
                    }
                }
            }
            if (!check)
                break;
        }
    }

    private static void output() {
        System.out.println(check ? "YES" : "NO");
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
            output();
        }
    }
}

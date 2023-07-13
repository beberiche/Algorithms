package Q17675_민석이의_마니또;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static BufferedReader br;
    static StringTokenizer stk;
    static StringBuilder sb;
    static int N, M, ans = 0, visited[];


    static class Node {
        int next;
        int dist;

        Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }
    static PriorityQueue<Node> pq;
    static List<Node> list[];

    private static void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        list = new ArrayList[N + 1];
        ans = 987654321;
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int n1, n2, d;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());
            d = Integer.parseInt(stk.nextToken());
            list[n1].add(new Node(n2, d));
        }
    }

    private static void bfs(int start) {
        pq = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (Node n : list[curr.next]) {
                if (visited[n.next] > 0) continue;
                visited[n.next]++;
                if (start == n.next) ans = Math.min(ans, curr.dist + n.dist);
                pq.add(new Node(n.next, curr.dist + n.dist));
            }
        }
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            visited = new int[N + 1];
            bfs(i);
        }
    }

    private static void output(int t) {
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input();
            solve();
            output(t);
        }
        System.out.print(sb.toString());
    }
}

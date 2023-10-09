package Q1774_우주신과의_교감;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 크루스칼
// 모든 행성 간 연결리스트 생성, 단 dist = 유클리드 거리를 기반으로 구한다.
// 미리 연결할 애들 연결.
// 탐색하여 대표값이 맞지 않는 애들을 기반으로, 거리 구하기
public class Main {
    static int N, M, arr[][], p[];
    static double ans;
    static List<Edge> list[];

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double dist;

        Edge(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }


        @Override
        public int compareTo(Edge E) {
            return this.dist <= E.dist ? -1 : 1;
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());

            int n1 = find(Integer.parseInt(stk.nextToken()));
            int n2 = find(Integer.parseInt(stk.nextToken()));

            union(n1, n2);
        }
    }

    private static void union(int n1, int n2) {
        if (n1 < n2) {
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        p[n1] = n2;
    }

    private static int find(int num) {
        if (num == p[num]) return num;
        return p[num] = find(p[num]);
    }

    private static void solve() {

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double d1 = Math.pow(arr[i][0] - arr[j][0], 2);
                double d2 = Math.pow(arr[i][1] - arr[j][1], 2);
                double ret = Math.sqrt(d1 + d2);
                list[i].add(new Edge(i, j, ret));
            }
            pq.addAll(list[i]);
        }


        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            int n1 = find(curr.from);
            int n2 = find(curr.to);

            if (n1 != n2) {
                union(n1, n2);
                ans += curr.dist;
            }
        }
    }

    private static void output() {
        System.out.println(String.format("%.2f", ans));
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

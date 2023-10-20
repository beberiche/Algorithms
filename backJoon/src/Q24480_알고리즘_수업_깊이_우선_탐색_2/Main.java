package Q24480_알고리즘_수업_깊이_우선_탐색_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Integer> pq[];
    static int N, M, R, visited[], idx = 0;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        pq = new PriorityQueue[N + 1];
        for (int i = 1; i <= N; i++) {
            pq[i] = new PriorityQueue<>((n1, n2) -> n2 - n1);
        }

        visited = new int[N + 1];
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            pq[n1].add(n2);
            pq[n2].add(n1);
        }
    }

    private static void solve(int num) {
        visited[num] = ++idx;
        while (!pq[num].isEmpty()) {
            int next = pq[num].poll();
            if (visited[next] == 0) solve(next);
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve(R);
        output();
    }
}

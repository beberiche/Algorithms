package Q5567_결혼식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer> list[] = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        System.out.println(bfs(list));
    }

    private static int bfs(List<Integer> list[]) {
        int[] dist = new int[list.length];
        final int INF = (int) 1e9;
        Arrays.fill(dist, INF);
        dist[1] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, dist[1]});

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int next : list[cur[0]]) {
                if (next == 1 || dist[next] != INF) continue;
                dist[next] = cur[1] + 1;
                if (dist[next] <= 2) {
                    cnt++;
                    q.add(new int[]{next, dist[next]});
                }
            }
        }
        return cnt;
    }
}

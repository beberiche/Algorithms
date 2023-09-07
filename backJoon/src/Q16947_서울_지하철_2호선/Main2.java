package Q16947_서울_지하철_2호선;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 사이클 찾고, 사이클에 존재하는 모든 노드 표기,
// 사이클에 해당하는 모든 노드를 큐에 담아 BFS (최소거리 구하기 이므로)
public class Main2 {
    static int N, isCycle[], visited[], dist[];
    static List<Integer> list[];
    static boolean check = false;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
    }

    private static void cycle(int st, int ed, int cnt) {
        visited[st] = 1;

        for (int next : list[st]) {
            if (isCycle[ed] == 1) return;
            if (next == ed && cnt >= 2) {
                isCycle[next] = 1;
                return;
            }
            if (visited[next] > 0) continue;
            cycle(next, ed, cnt + 1);
        }
    }

    private static void bfs() {
        visited = new int[N + 1];
        dist = new int[N + 1];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (isCycle[i] == 1) {
                visited[i] = 1;
                q.add(new int[]{i, 0});
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (dist[curr[0]] == 0 && isCycle[curr[0]] == 0) {
                dist[curr[0]] = curr[1];
            }
            for (int next : list[curr[0]]) {
                if (visited[next] == 0) {
                    visited[next] = 1;
                    q.add(new int[]{next, curr[1] + 1});
                }
            }
        }
    }

    private static void solve() {
        // 사이클 찾기
        isCycle = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            check = false;
            visited = new int[N + 1];
            cycle(i, i, 0);
        }

        bfs();
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

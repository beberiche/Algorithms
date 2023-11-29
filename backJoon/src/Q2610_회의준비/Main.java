package Q2610_회의준비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int p[];

    private static int find(int num) {
        if (num == p[num]) return num;
        return find(p[num]);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], (int) 1e9);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            dist[n1][n2] = 1;
            dist[n2][n1] = 1;

            int x = find(n1);
            int y = find(n2);

            if (x != y) {
                p[x < y ? y : x] = x < y ? x : y;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        Map<Integer, int[]> m = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int x = find(i);
            int max = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] != (int) 1e9) {
                    max = Math.max(max, dist[i][j]);
                }
            }
            if (m.containsKey(x)) {
                int[] curr = m.get(x);
                if (curr[1] > max) m.put(x, new int[]{i, max});
            } else {
                m.put(x, new int[]{i, max});
            }
        }
        Set<Integer> s = m.keySet();
        PriorityQueue<Integer> pq = new PriorityQueue();

        StringBuilder sb= new StringBuilder();
        sb.append(s.size()).append("\n");
        for(int key : s) {
            pq.add(m.get(key)[0]);
        }

        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.print(sb.toString());
    }
}

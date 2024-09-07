package Q21738_얼음깨기_펭귄;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        List<Integer> list[] = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            list[A].add(B);
            list[B].add(A);
        }

        boolean[] visited = new boolean[N + 1];

        // 현재 노드, 이동한 갯수
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{K, 0});
        visited[K] = true;
        int cnt = 1;
        int flag = 0;

        while (!q.isEmpty() && flag < 2) {
            int[] curr = q.poll();

            if (curr[0] <= S) {
                cnt += curr[1];
                flag++;
                continue;
            }

            for (int next : list[curr[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, curr[1] + 1});
                }
            }
        }

        System.out.println(N - cnt);
    }
}

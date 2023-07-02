package Q13549_숨바꼭질_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
// 2N <= K+1 인 경우에만 순간이동
public class Main {
    static int N, K;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
    }

    private static int solve() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        int visited[] = new int[100004];
        visited[N] = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == K) return curr[1];

            if (curr[0] * 2 <= K+1 && visited[curr[0] * 2] == 0) {
                visited[curr[0] * 2] = 1;
                q.add(new int[]{curr[0] * 2, curr[1]});
            }
            if (curr[0] - 1 >= 0 && visited[curr[0] - 1] == 0) {
                visited[curr[0] - 1] = 1;
                q.add(new int[]{curr[0] - 1, curr[1] + 1});
            }
            if (curr[0] + 1 <= 100000 && visited[curr[0] + 1] == 0) {
                visited[curr[0] + 1] = 1;
                q.add(new int[]{curr[0] + 1, curr[1] + 1});
            }

        }
        return -1;
    }

    private static void output(int ans) {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        int ans = solve();
        output(ans);
    }
}

package Q14226_이모티콘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int S,ans;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        boolean visited[][] = new boolean[1002][1002];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0});
        visited[1][0] = true;
        while (!q.isEmpty()) {
            // curr[0] : 화면
            // curr[1] : 클립보드
            int[] curr = q.poll();

            if (curr[0] == S) {
                ans = curr[2];
                break;
            }

            // 1
            if (!visited[curr[0]][curr[0]]) {
                visited[curr[0]][curr[0]] = true;
                q.add(new int[]{curr[0], curr[0], curr[2] + 1});
            }

            // 2
            if (curr[1] > 0 && curr[0] + curr[1] <= 1000 && !visited[curr[0] + curr[1]][curr[1]]) {
                visited[curr[0] + curr[1]][curr[1]] = true;
                q.add(new int[]{curr[0] + curr[1], curr[1], curr[2] + 1});
            }

            // 3
            if (curr[0] - 1 > 0 && !visited[curr[0] - 1][curr[1]]) {
                visited[curr[0] - 1][curr[1]] = true;
                q.add(new int[]{curr[0] - 1, curr[1], curr[2] + 1});
            }
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

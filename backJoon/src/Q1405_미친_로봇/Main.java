package Q1405_미친_로봇;

// 동일한 장소는 방문안함
// N만큼의 중복순열
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double dir[], ans;
    static int dr[] = {0, 0, 1, -1};
    static int dc[] = {1, -1, 0, 0};
    static boolean visited[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());

        dir = new double[4];
        for (int i = 0; i < 4; i++) {
            dir[i] = Double.parseDouble(stk.nextToken()) * 0.01;
        }

        visited = new boolean[40][40];
        visited[20][20] = true;
        dfs(20, 20, 0, 1.0);
        visited[20][20] = false;

        System.out.println(ans);
    }

    private static void dfs(int r, int c, int cnt, double ret) {
        if (cnt >= N) {
            ans += ret;
            return;
        }


        for (int d = 0; d < 4; d++) {
            if (dir[d] == 0.0) continue;

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr, nc, cnt + 1, ret * dir[d]);
            visited[nr][nc] = false;
        }
    }
}

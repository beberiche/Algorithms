package Q18290_NM과_K_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, M, K;
    static int ans = -40001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        comb(0, -1, 0, 0);

        System.out.println(ans);
    }

    private static void comb(int r, int c, int cnt, int sum) {
        if (cnt >= K) {
            ans = Math.max(sum, ans);
            return;
        }

        int tempI = c + 1 >= M ? r + 1 : r;
        int tempJ = c + 1 >= M? 0 : c + 1;
        for (int i = tempI; i < N; i++) {
            for (int j = tempJ; j < M; j++) {
                int mi = i - 1;
                int mj = j - 1;
                if (mi >= 0 && visited[mi][j]) continue;
                if (mj >= 0 && visited[i][mj]) continue;

                visited[i][j] = true;
                comb(i, j, cnt + 1, sum + map[i][j]);
                visited[i][j] = false;
            }
            tempJ = 0;
        }
    }
}

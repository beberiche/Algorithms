package Q18290_NM과_K_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
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

        int[][] sel = new int[K][2];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 2; j++) {
                sel[i][j] = -1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sel[0][0] = i;
                sel[0][1] = j;
                comb(i, j, 1, map[i][j], sel);
                sel[0][0] = -1;
                sel[0][1] = -1;
            }
        }
        System.out.println(ans);
    }

    private static void comb(int r, int c, int cnt, int sum, int[][] sel) {
        if (cnt >= K) {
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = r; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Math.abs(i - r) + Math.abs(j - c) <= 1) continue;
                if (check(sel, i, j)) continue;
                sel[cnt][0] = i;
                sel[cnt][1] = j;
                comb(i, j, cnt + 1, sum + map[i][j], sel);
                sel[cnt][0] = -1;
                sel[cnt][1] = -1;
            }
        }
    }

    private static boolean check(int[][] sel, int r, int c) {
        for (int i = 0; i < K; i++) {
            if (sel[i][0] == -1) continue;
            if (Math.abs(sel[i][0] - r) + Math.abs(sel[i][1] - c) <= 1) return true;
        }
        return false;
    }

}

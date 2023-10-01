package Q2617_구슬_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static int N, M, map[][];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N + 1][N + 1];
        int n1, n2;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());

            map[n1][n2] = 1;
        }
    }

    private static void solve() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }
    }

    private static void output() {
        int mid = N / 2;
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int c = 0;
            int h = 0;
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) h++;
                if (map[j][i] == 1) c++;
            }

            if (c > mid || h > mid) ans++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

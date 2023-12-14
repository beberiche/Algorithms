package Q1749_점수따먹기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N, M, arr[][], ans;

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
        System.out.println(ans);
    }

    private void solve() {
        ans = Integer.MIN_VALUE;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                for (int i = r; i <= N; i++) {
                    for (int j = c; j <= M; j++) {
                        int num = arr[i][j] - arr[i - r][j] - arr[i][j - c] + arr[i - r][j - c];
                        ans = Math.max(ans, num);
                    }
                }
            }
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int num = Integer.parseInt(stk.nextToken());
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] + num - arr[i - 1][j - 1];
            }
        }
    }
}

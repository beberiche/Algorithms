package Q2660_회장뽑기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, arr[][], min, cnt, INF = 987654321;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }
        StringTokenizer stk;
        while (true) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());

            if (n1 < 0 && n2 < 0) break;

            arr[n1][n2] = 1;
            arr[n2][n1] = 1;
        }
    }

    private static void solve() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }


    }

    private static void output() {
        int[] scoreArr = new int[N + 1];
        int min = INF;
        for (int i = 1; i <= N; i++) {
            int ret = 0;
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != INF) {
                    ret = Math.max(arr[i][j], ret);
                }
            }
            scoreArr[i] = ret;
            min = Math.min(min, scoreArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append(min).append(" ");
        for (int i = 1; i <= N; i++) {
            if (min == scoreArr[i]) {
                cnt++;
                sb2.append(i).append(" ");
            }
        }

        sb.append(cnt);
        System.out.println(sb.toString());
        System.out.print(sb2.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}

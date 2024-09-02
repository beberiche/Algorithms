package Q1058_친구;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] a = new int[N + 1][N + 1];

        int INF = 987654321;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                a[i][j] = INF;
            }
        }

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'Y' && a[i][j + 1] == INF) {
                    a[i][j + 1]=1;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i != j && a[i][k] != INF && a[k][j] != INF) {
                        a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (a[i][j] <= 2) cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}

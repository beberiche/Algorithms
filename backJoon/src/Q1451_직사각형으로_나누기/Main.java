package Q1451_직사각형으로_나누기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        long[][] arr = new long[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                long num = str.charAt(j - 1) - '0';
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] + num - arr[i - 1][j - 1];
            }
        }

        long ans = 0;
        // ||
        for (int i = 1; i <= M - 1; i++) {
            for (int j = i + 1; j <= M; j++) {
                long x = arr[N][i];
                long y = arr[N][j] - arr[N][i];
                long z = arr[N][M] - arr[N][j];

                ans = Math.max(ans, x * y * z);
            }
        }

        // =
        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                long x = arr[i][M];
                long y = arr[j][M] - arr[i][M];
                long z = arr[N][M] - arr[j][M];

                ans = Math.max(ans, x * y * z);
            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                long x, y, z;

                // ㅗ
                x = arr[i][j];
                y = arr[i][M] - arr[i][j];
                z = arr[N][M] - arr[i][M];

                ans = Math.max(ans, x * y * z);

                // ㅜ
                x = arr[i][M];
                y = arr[N][j] - arr[i][j];
                z = arr[N][M] - arr[N][j] - arr[i][M] + arr[i][j];

                ans = Math.max(ans, x * y * z);

                // ㅓ
                x = arr[i][j];
                y = arr[N][j] - arr[i][j];
                z = arr[N][M] - arr[N][j];

                ans = Math.max(ans, x * y * z);

                // ㅏ
                x = arr[N][j];
                y = arr[i][M] - arr[i][j];
                z = arr[N][M] - arr[N][j] - arr[i][M] + arr[i][j];

                ans = Math.max(ans, x * y * z);
            }
        }


        System.out.println(ans);
    }
}

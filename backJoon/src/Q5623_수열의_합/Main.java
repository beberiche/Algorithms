package Q5623_수열의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N][N];
        int sumA = 0; // A
        int sumB = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
                if (i < j) {
                    sumA += a[i][j];
                }
                if (i == 0 && i < j) {
                    sumB += a[i][j];
                }
            }
        }

        if (N == 2) {
            System.out.println(1+ " " + 1);
            return;
        }

        sumA /= N - 1;
        int ret = (sumB - sumA) / (N - 2);
        StringBuilder sb = new StringBuilder();
        sb.append(ret);
        for (int j = 1; j < N; j++) {
            sb.append(" ").append(a[0][j] - ret);
        }
        System.out.print(sb);
    }
}

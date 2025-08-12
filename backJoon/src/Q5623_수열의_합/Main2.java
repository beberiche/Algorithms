package Q5623_수열의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        if (N == 2) {
            int half = a[0][1] / 2;
            System.out.println(half + " " + half);
            return;
        }

        int first = (a[0][1] + a[0][2] - a[1][2]) / 2;

        StringBuilder sb = new StringBuilder();
        sb.append(first);

        for (int j = 1; j < N; j++) {
            sb.append(" ").append(a[0][j] - first);
        }
        System.out.println(sb);
    }
}

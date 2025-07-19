package Q1531_투명;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] a = new int[100][100];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken()) - 1;
            int y1 = Integer.parseInt(stk.nextToken()) - 1;
            int x2 = Integer.parseInt(stk.nextToken()) - 1;
            int y2 = Integer.parseInt(stk.nextToken()) - 1;

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    a[j][k]++;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (a[i][j] > M) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}

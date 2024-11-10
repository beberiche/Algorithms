package Q1236_성_지키기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        char[][] a = new char[N][M];
        int[] row = new int[N];
        int[] col = new int[M];
        for (int i = 0; i < N; i++) {
            a[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 'X') {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int rcnt = 0;
        int ccnt = 0;
        for (int i = 0; i < N; i++) {
            if (row[i] == 0) rcnt++;
        }

        for (int j = 0; j < M; j++) {
            if (col[j] == 0) ccnt++;
        }

        System.out.println(Math.max(rcnt, ccnt));
    }
}

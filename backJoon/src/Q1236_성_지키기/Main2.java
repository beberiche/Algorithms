package Q1236_성_지키기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] row = new int[N];
        int[] col = new int[M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'X') {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int rowCnt = 0;
        int colCnt = 0;
        for (int i = 0; i < N; i++) {
            if (row[i] == 0) rowCnt++;
        }

        for (int j = 0; j < M; j++) {
            if (col[j] == 0) colCnt++;
        }

        System.out.println(Math.max(rowCnt, colCnt));
    }
}

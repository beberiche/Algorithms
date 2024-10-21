package Q1051_숫자_정사각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] a = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                a[i][j] = str.charAt(j) - '0';
            }
        }

        int w = Math.min(N, M);

        for (int i = w; i >= 1; i--) {
            for (int j = 0; j < N; j++) {
                if (j + i >= N) break;
                for (int k = 0; k < M; k++) {
                    if (k + i >= M) break;
                    int n1 = a[j][k];
                    int n2 = a[j][k+i];
                    int n3 = a[j+i][k];
                    int n4 = a[j+i][k+i];

                    if(n1 == n2 && n2 == n3 && n3 == n4){
                        System.out.println((i+1)*(i+1));
                        return;
                    }
                }
            }
        }
        System.out.println(1);
    }
}

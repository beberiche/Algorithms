package Q2740_행렬_곱셈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int[][] B = new int[M][K];
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[][] ret = new int[N][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) {
                    ret[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) {
                System.out.print(ret[i][j]+" ");
            }
            System.out.println();
        }
    }
}

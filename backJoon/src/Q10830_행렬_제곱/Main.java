package Q10830_행렬_제곱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A[][], N;
    static Long B;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        B = Long.parseLong(stk.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(stk.nextToken()) % 1000;
            }
        }
    }

    private static int[][] solve(int[][] curr, Long pow) {
        if (pow == 1L) return curr;
        curr = solve(curr, pow / 2);

        curr = go(curr, curr);
        if (pow % 2 == 1L) curr = go(curr, A);

        return curr;
    }

    private static int[][] go(int[][] arr1, int[][] arr2) {
        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += (arr1[i][k] * arr2[k][j]) % 1000;
                }
            }
        }

        return ret;
    }

    private static void output(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]%1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        int[][] ret = solve(A, B);
        output(ret);
    }
}

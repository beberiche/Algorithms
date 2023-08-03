package Q11444_피보나치_수_6;

import java.util.Scanner;

public class Main {
    static Long N;
    static long[][] A = new long[][]{{1, 1}, {1, 0}};
    static int DIV = 1000000007;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
    }

    private static long[][] go(long[][] arr1, long[][] arr2) {
        long[][] arr = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                    arr[i][j] %= DIV;
                }
            }
        }
        return arr;
    }

    private static long[][] solve(long[][] arr, long pow) {
        if (pow <= 1L) return A;

        long[][] ret = solve(arr, pow / 2);
        ret = go(ret, ret);
        if (pow % 2 == 1L) ret = go(ret, A);

        return ret;
    }

    private static void output(long[][] arr) {
        System.out.println(arr[1][0]%DIV);
    }

    public static void main(String[] args) {
        input();
        long[][] ans = solve(A, N);
        output(ans);
    }
}

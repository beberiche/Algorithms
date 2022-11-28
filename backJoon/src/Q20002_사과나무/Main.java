package Q20002_사과나무;

import java.util.Scanner;

public class Main {
    static int n;
    static int result;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n + 1];
        result = Integer.MIN_VALUE;
        int tmp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++)
                map[i][j] = map[i][j - 1] + sc.nextInt();
        }

        for (int k = 1; k <= n; k++) {
            for (int j = k; j <= n; j++) {
                for (int i = 0; i <= n - k; i++) {
                    tmp = 0;
                    for (int l = 0; l < k; l++) {
                        tmp += map[i + l][j] - map[i + l][j - k];
                    }
                    result = Math.max(result, tmp);
                }
            }
        }

        System.out.println(result);
    }
}
